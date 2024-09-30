/*
  https://contest.yandex.ru/contest/27663/problems/G/

  Широко известна следующая задача для младших школьников. 
  Три черепахи ползут по дороге. 
  Одна черепаха говорит: “Впереди меня две черепахи”. 
  Другая черепаха говорит: “Позади меня две черепахи”. 
  Третья черепаха говорит: “Впереди меня две черепахи и позади меня две черепахи”. 
  Как такое может быть? Ответ: третья черепаха врет! 
  
  По дороге одна за другой движутся N черепах. 
  Каждая черепаха говорит фразу вида: 
  “Впереди меня a_i черепах, а позади меня b_i черепах”. 
  Ваша задача определить, сколько самое большее количество черепах могут 
  говорить правду.

  # Формат ввода:
  В первой строке вводится целое число N (1 ≤ N ≤ 10 000) строк, 
  содержащих целые числа a_i и b_i, по модулю не превосходящие 10 000, 
  описывающие высказывание i-ой черепахи.

  # Формат вывода:
  Выведите целое число M – максимальное количество черепах, 
  которые могут говорить правду.

  # Пример 1:
  ~~~~~~~~~ Ввод:
  3
  2 0
  0 2
  2 2
  ~~~~~~~~~ Вывод:
  2

  # Пример 2:
  ~~~~~~~~~ Ввод:
  5
  0 4
  1 3
  2 2
  3 1
  4 0
  ~~~~~~~~~ Вывод:
  5

  # Пример 3:
  ~~~~~~~~~ Ввод:
  10
  9 1
  8 1
  7 2
  6 2
  5 3
  4 4
  3 6
  2 7
  1 9
  0 8
  ~~~~~~~~~ Вывод:
  4
 */