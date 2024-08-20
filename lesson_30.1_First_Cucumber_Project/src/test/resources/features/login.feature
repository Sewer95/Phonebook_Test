Feature: Login

  @Login
  Scenario: Успешный логин юзера
    Given Пользователь запускает браузер
    When Пользователь открывает домашнюю страницу ilcarro
    And Пользователь нажимает на ссылку Log in
    And Пользователь вводит валидные данные
    And Пользователь нажимает на кнопку Yalla
    Then  Пользователь проверяет отображение сообщения от успешном логине
    And Пользователь закрывает браузер


  @InvalidPassword
  Scenario Outline: Неуспешный логин юзера
    Given Пользователь запускает браузер
    When Пользователь открывает домашнюю страницу ilcarro
    And Пользователь нажимает на ссылку Log in
    And Пользователь вводит валидный email и невалидный пароль
      | email   | password   |
      | <email> | <password> |
    And Пользователь нажимает на кнопку Yalla
    Then  Пользователь проверяет отображение сообщения от неуспешном логине
    And Пользователь закрывает браузер
    Examples:
      | email                    | password  |
      | shvets1.serhii@gmail.com | Qwertz@12 |
      | shvets1.serhii@gmail.com | Qwertz@   |
      | shvets1.serhii@gmail.com | qwertz@1  |
      | shvets1.serhii@gmail.com | Qwertz123 |
