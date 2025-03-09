<?php

function generateBoard($rows, $cols, $word) {
    $board = array_fill(0, $rows, array_fill(0, $cols, 'o'));
    $mid = floor($rows / 2);

    // Crear rombo completo
    for ($i = 0; $i < $rows; $i++) {
        $offset = abs($mid - $i); // Distancia desde el centro
        for ($j = $offset; $j < $cols - $offset; $j++) {
            $board[$i][$j] = '*';
        }
    }

    // Esconder letras de la palabra al azar
    $positions = [];
    for ($i = 0; $i < $rows; $i++) {
        for ($j = 0; $j < $cols; $j++) {
            if ($board[$i][$j] === '*') {
                $positions[] = [$i, $j];
            }
        }
    }

    shuffle($positions);
    $_SESSION['hidden_letters'] = []; // Almacena las letras ocultas
    foreach (str_split($word) as $letter) {
        if (!empty($positions)) {
            [$r, $c] = array_pop($positions);
            $_SESSION['hidden_letters']["$r,$c"] = $letter;
        }
    }

    return $board;
}

function getHiddenLetter($row, $col) {
    $key = "$row,$col";
    return $_SESSION['hidden_letters'][$key] ?? null;
}