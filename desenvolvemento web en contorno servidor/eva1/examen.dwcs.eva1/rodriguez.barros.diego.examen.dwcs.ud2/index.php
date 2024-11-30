<?php
session_start();
require_once 'functions.php';

// Inicialización y validación del formulario
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['setup'])) {
    $rows = $_POST['rows'];
    $cols = $_POST['cols'];
    $word = strtoupper(trim($_POST['word']));
    
    $errors = [];
    
    if (!is_numeric($rows) || $rows < 5 || $rows > 30 || $rows % 2 == 0) {
        $errors[] = "El número de filas debe ser impar y estar entre 5 y 30.";
    }
    if (!is_numeric($cols) || $cols < 5 || $cols > 30 || $cols % 2 == 0) {
        $errors[] = "El número de columnas debe ser impar y estar entre 5 y 30.";
    }
    if (strlen($word) < 5) {
        $errors[] = "La palabra debe tener al menos 5 letras.";
    }
    
    if (empty($errors)) {
        // Configurar el tablero y el juego
        $_SESSION['rows'] = $rows;
        $_SESSION['cols'] = $cols;
        $_SESSION['word'] = $word;
        $_SESSION['board'] = generateBoard($rows, $cols, $word);
        $_SESSION['score'] = 0;
        $_SESSION['misses'] = 0;
        
        header('Location: index.php');
        exit;
    }
}

// Manejo de clics en el tablero
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['click']) && isset($_POST['cell'])) {
    $cell = $_POST['cell'];
    [$row, $col] = explode(',', $cell);

    if (isset($_SESSION['board'][$row][$col]) && $_SESSION['board'][$row][$col] === '*') {
        $letter = getHiddenLetter($row, $col);
        if ($letter) {
            $_SESSION['board'][$row][$col] = $letter;
            $_SESSION['score'] += 5;
            
            // Eliminar todas las ocurrencias de la letra encontrada
            if (strpos($_SESSION['word'], $letter) !== false) {
                $_SESSION['word'] = str_replace($letter, '', $_SESSION['word']);
            }
            

            unset($_SESSION['hidden_letters']["$row,$col"]);
        } else {
            $_SESSION['board'][$row][$col] = '-';
            $_SESSION['score'] = max(0, $_SESSION['score'] - 2); // Evitar marcador negativo
            $_SESSION['misses']++;
        }
    }

    // Comprobación de condiciones de fin del juego
    if (empty($_SESSION['word'])) {
        $message = "¡Felicidades! Has encontrado todas las letras.";
        session_destroy();
    } elseif ($_SESSION['misses'] > 3) {
        $message = "Has fallado más de 3 veces. Fin del juego.";
        session_destroy();
    }
}

?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Juego de Tablero</title>
</head>
<body>
<h1>Juego del Tablero</h1>

<?php if (!isset($_SESSION['board'])): ?>
    <form method="POST">
        <label for="rows">Filas (impar, 5-30):</label>
        <input type="number" name="rows" id="rows" required>
        <br>
        <label for="cols">Columnas (impar, 5-30):</label>
        <input type="number" name="cols" id="cols" required>
        <br>
        <label for="word">Palabra (mínimo 5 letras):</label>
        <input type="text" name="word" id="word" required>
        <br>
        <button type="submit" name="setup">Enviar</button>
    </form>
    
    <?php if (!empty($errors)): ?>
        <ul>
            <?php foreach ($errors as $error): ?>
                <li><?= htmlspecialchars($error) ?></li>
            <?php endforeach; ?>
        </ul>
    <?php endif; ?>

<?php else: ?>
    <h2>Marcador: <?= $_SESSION['score'] ?></h2>
    <form method="POST">
        <table border="1">
            <?php foreach ($_SESSION['board'] as $rowIndex => $row): ?>
                <tr>
                    <?php foreach ($row as $colIndex => $cell): ?>
                        <td>
                            <?php if ($cell === '*'): ?>
                                <button type="submit" name="cell" value="<?= $rowIndex . ',' . $colIndex ?>">*</button>
                            <?php else: ?>
                                <?= htmlspecialchars($cell) ?>
                            <?php endif; ?>
                        </td>
                    <?php endforeach; ?>
                </tr>
            <?php endforeach; ?>
        </table>
        <input type="hidden" name="click" value="1">
    </form>
    <p>Palabra restante: <?= htmlspecialchars($_SESSION['word']) ?></p>
    <?php if (isset($message)): ?>
        <p><?= htmlspecialchars($message) ?></p>
    <?php endif; ?>
<?php endif; ?>
</body>
</html>
