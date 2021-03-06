# language: ru
@all @sberbank @hw27
Функционал: https://www.sberbank.ru/
  Сценарий: вход на сайт, переход во вклады, подбор вклада
    Дано пользователь переходит на сайт  "https://www.sberbank.ru/"
    Тогда название страницы содержит "«Сбербанк» - Частным клиентам"
    Затем пользователь через верхнее меню переходит во "Вклады"
    Тогда название страницы содержит "«Сбербанк» - Подбор вкладов"
    Когда пользователь переходит на вкладку "Подобрать вклад"
    Тогда отображаются 4 чек-бокса
      | Хочу снимать |
      | Хочу пополнять |
      | Онлайн |
      | Я - пенсионер |
    И установлен чекбокс "Онлайн"
    И отображается 3 вклада
      | Вклад Сохраняй |
      | Вклад Управляй |
      | Вклад Пополняй |
    Когда пользователь выбирает чек-боксы
    | Хочу снимать |
    | Хочу пополнять |
    Тогда исчезают вклады Сохраняй и Пополняй. Остался только "Вклад Управляй"
    Затем пользователь нажимает на кнопку Подробнее вклада Управляй
    Тогда в новом окне открылось окно с названием "«Сбербанк» - Вклад Управляй"
    И  на странице отображается надпись "Вклад Управляй"