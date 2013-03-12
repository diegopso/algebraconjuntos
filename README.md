algebraconjuntos
================

Esta é uma API de Álgebra de Conjuntos, desenvolvida por Diego Oliveira, Gabriela Brito e Jeferson Moraes. Para utilizá-la, é necessário conferir as instruções seguintes:

## Elemento < T > ##

Esta classe representa os elementos de um conjunto. O valor do elemento pode ser de qualquer tipo.

### T valor ###

Esta propriedade recebe o valor do elemento.

### pertence(Conjunto c) ###

Este método trata da Pertinência entre elemento e conjunto.
Parâmetro:
`Conjunto c - Verifica se o elemento está no conjunto em questão.`
Retorno:
`Verdadeiro se pertencer. Falso se não pertencer.`

### equals(Elemento obj) ###

Este método verifica se um elemento é igual a outro elemento.
Parâmetro: 
`Elemento obj - É o elemento a ser comparado.`
Retorno:
`Verdadeiro se os elementos forem iguais. Falso se os elementos forem diferentes.`

### compareTo (T o)###

Este método compara os elementos.
Parâmetro: 
`o - este é o objeto a ser comparado.`
Retorno:
`um inteiro negativo, 0, ou um inteiro positivo, quando o objeto for menor do que, igual a, ou maior do que o objeto especificado.`

## Conjunto ##

Esta classe representa um conjunto.

### List < Elemento > elementos ###

A lista que armazena os elementos.

### Conjunto () ###

Cria uma lista de elementos vazia.

### Conjunto (List<Elemento> elementos) ###

Cria uma lista com os elementos passados como parâmetro.

Parâmetro:
`A lista elementos recebe um arraylist de elementos`

### contem (Conjunto c) ###

Este método trata a continência entre conjuntos.

Parâmetro:
`Conjunto c -é o conjunto que vai ser verificado se está contido no conjunto atual (this).`
Retorno: 
`False para não está contido, e True para está contido ou é igual.`

### igual (Conjunto c) ###

Este método trata da igualdade entre conjuntos.

Parâmetro:
`Conjunto c - é o conjunto a ser verificado se é igual ao conjunto atual.`
Retorno: 
`False para diferente, True para igual.`

### cardinalidade ()###

Este método trata da cardinalidade do conjunto, ou seja mostra a quantidade de elementos do conjunto.

Retorno:
`Int - retorna a quantidade de elementos do conjunto`

### uniao (Conjunto c) ###

Este método resulta em um conjunto constituído pelos elementos que pertecem ao conjunto atual (this) ou ao conjunto c.

Parâmetro:
`Conjunto c - é o conjunto que vai se unir ao conjunto atual.`
Retorno:
`O retorno será a união dos conjuntos.`

### intersecao (Conjunto c) ###

Este método resulta em um conjunto constituído pelos elementos que pertencem ao conjunto atual (this) e ao conjunto c.

Parâmetro:
`Conjunto c - o conjunto c é o conjunto que será feito a interseção com o conjunto atual.`
Retorno:
`o conjunto que irá conter os elementos do conjunto atual e do conjunto c`

### diferenca (Conjunto c) ###

Este método resulta de um conjunto constituido pelos elementos que pertencem ao conjunto atual (this) e não pertencem ao conjunto c.

Parâmetro:
`Conjunto c - o conjunto c é o conjunto que será comparado com o conjunto atual, removendo os elementos iguais.`
Retorno:
`Retorna o conjunto dos elementos que estão no conjunto atual e não estão no conjunto c.`

### produtoCartesiano (Conjunto b) ###

Este método resulta no conjunto de sequências de tuplas, em que o primeiro elemento de cada sequência é um elemento do conjunto atual, e o segundo do conjunto b.

Parâmetro:
`Conjunto b - é o conjunto que será relacionado ao conjunto atual.`
Retorno:
`retorna o produto cartesiano entre o conjunto atual e o conjunto b.`
