Feature: Let the car work

  @LetTheCarWork
  Scenario: Успешное добавление автомобиля
    Given Пользователь запускает браузер
    When Пользователь открывает домашнюю страницу ilcarro
    And Пользователь нажимает на ссылку Let the car work
    And Пользователь вводит локацию Haifa, Israel
    And Пользователь вводит данные автомобиля и добавляет фото
    And Пользователь нажимает на кнопку Submit
    Then  Пользователь проверяет отображение сообщения об успешном добавлении авто
    And Пользователь закрывает браузер