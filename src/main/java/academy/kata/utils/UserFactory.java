package academy.kata.utils;

import academy.kata.model.User;

import java.sql.Date;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;


public class UserFactory {

    public static User getDefaultUser() {

        String name = "no_name";
        LocalDate localDate = LocalDate.now();   // Получаем текущую дату как LocalDate
        Date sqlDate = Date.valueOf(localDate);   // Преобразуем LocalDate в java.sql.Date
        String address = "no_address";

        return new User(name, sqlDate, address);
    }


    public static User[] generateUsers(int count) {
        User[] users = new User[count];
        for (int i = 0; i < users.length; i++) {
            users[i] = userGenerator();
        }
        return users;
    }


    private static User userGenerator() {
        String[] firstName = {
                "Александр", "Сергей", "Дмитрий", "Андрей", "Алексей", "Максим", "Евгений", "Николай", "Иван", "Владимир", "Юрий", "Михаил", "Павел", "Олег", "Игорь", "Артем", "Анатолий", "Виктор", "Роман", "Валерий", "Василий", "Вячеслав", "Григорий", "Константин", "Борис", "Антон", "Владислав", "Леонид", "Станислав", "Георгий", "Артур", "Вадим", "Виталий", "Юрий", "Руслан", "Никита", "Глеб", "Герман", "Федор", "Семен", "Аркадий", "Петр", "Егор", "Захар", "Ярослав", "Серафим", "Марк", "Тимур", "Савелий", "Даниил", "Денис", "Кирилл", "Матвей", "Гриша", "Елисей", "Валентин", "Эдуард", "Богдан", "Арсений", "Святослав", "Рустам", "Анатолий", "Лев", "Ростислав", "Эмиль", "Ринат", "Эрнест", "Аким", "Савва", "Геннадий", "Назар", "Нестор", "Тихон", "Альберт", "Всеволод", "Альберт", "Василий", "Никанор", "Еремей", "Демьян", "Трофим", "Филипп", "Аверьян", "Яков", "Илья", "Захар", "Зиновий", "Марк", "Анатолий", "Олег", "Павел", "Радион", "Роберт", "Серафим", "Тимофей", "Филипп", "Ярослав", "Юрий"
        };
        String[] lastName = {
                "Иванов", "Смирнов", "Кузнецов", "Попов", "Васильев", "Петров", "Соколов", "Михайлов", "Новиков", "Федоров", "Морозов", "Волков", "Алексеев", "Лебедев", "Семенов", "Егоров", "Павлов", "Козлов", "Степанов", "Николаев", "Орлов", "Андреев", "Макаров", "Никитин", "Захаров", "Зайцев", "Соловьев", "Борисов", "Яковлев", "Григорьев", "Романов", "Воробьев", "Сергеев", "Кузьмин", "Фролов", "Александров", "Дмитриев", "Королев", "Гусев", "Киселев", "Ильин", "Максимов", "Поляков", "Сорокин", "Виноградов", "Ковалев", "Белов", "Медведев", "Антонов", "Тарасов", "Жуков", "Баранов", "Филиппов", "Комаров", "Давыдов", "Беляев", "Герасимов", "Богданов", "Овчинников", "Мартынов", "Федотов", "Карпов", "Бобров", "Анисимов", "Ефимов", "Тимофеев", "Игнатьев", "Афанасьев", "Логинов", "Савин", "Капустин", "Кириллов", "Моисеев", "Елисеев", "Кошелев", "Костин", "Горбачев", "Орехов", "Ефремов", "Исаев", "Евдокимов", "Калашников", "Кабанов", "Назаров", "Лобанов", "Лукин", "Беляков", "Потапов", "Некрасов", "Хохлов", "Журавлев", "Рыбаков", "Селезнев", "Панов", "Тихонов", "Гришин", "Кондратьев", "Кудрявцев", "Майоров"
        };
        String[] patronymic = {
                "Александрович", "Сергеевич", "Дмитриевич", "Андреевич", "Алексеевич", "Максимович", "Евгеньевич", "Николаевич", "Иванович", "Владимирович", "Юрьевич", "Михайлович", "Павлович", "Олегович", "Игоревич", "Артемович", "Анатольевич", "Викторович", "Романович", "Валерьевич", "Васильевич", "Вячеславович", "Григорьевич", "Константинович", "Борисович", "Антонович", "Владиславович", "Леонидович", "Станиславович", "Георгиевич", "Артурович", "Вадимович", "Витальевич", "Юрьевич", "Русланович", "Никитович", "Глебович", "Германович", "Федорович", "Семенович", "Аркадьевич", "Петрович", "Егорович", "Захарович", "Ярославович", "Серафимович", "Маркович", "Тимурович", "Савельевич", "Даниилович", "Денисович", "Кириллович", "Матвеевич", "Григорьевич", "Елисеевич", "Валентинович", "Эдуардович", "Богданович", "Арсениевич", "Святославович", "Рустамович", "Анатольевич", "Львович", "Ростиславович", "Эмильевич", "Ринатович", "Эрнестович", "Акимович", "Саввич", "Геннадиевич", "Назарович", "Несторович", "Тихонович", "Альбертович", "Всеволодович", "Альбертович", "Васильевич", "Никанорович", "Еремеевич", "Демьянович", "Трофимович", "Филиппович", "Аверьянович", "Яковлевич", "Ильич", "Захарович", "Зиновьевич", "Маркович", "Анатольевич", "Олегович", "Павлович", "Радионович", "Робертович", "Серафимович", "Тимофеевич", "Филиппович", "Ярославович", "Юрьевич"
        };
        String[] cities = {
                "Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Нижний Новгород", "Казань", "Челябинск", "Омск", "Самара", "Ростов-на-Дону", "Уфа", "Красноярск", "Пермь", "Воронеж", "Волгоград", "Краснодар", "Саратов", "Тюмень", "Тольятти", "Ижевск", "Барнаул", "Ульяновск", "Иркутск", "Хабаровск", "Ярославль", "Владивосток", "Махачкала", "Томск", "Оренбург", "Кемерово", "Новокузнецк", "Рязань", "Астрахань", "Набережные Челны", "Пенза", "Киров", "Липецк", "Балашиха", "Чебоксары", "Калининград", "Курск", "Улан-Удэ", "Ставрополь", "Тверь", "Магнитогорск", "Сочи", "Брянск", "Иваново", "Тульская", "Белгород", "Сургут", "Владимир", "Архангельск", "Нижний Тагил", "Симферополь", "Курган", "Смоленск", "Калуга", "Чита", "Орск", "Вологда", "Череповец", "Саранск", "Киров", "Петрозаводск", "Кострома", "Новороссийск", "Йошкар-Ола", "Стерлитамак", "Грозный", "Волжский", "Сыктывкар", "Нижневартовск", "Братск", "Ангарск", "Энгельс", "Армавир", "Мурманск", "Старый Оскол", "Бийск", "Прокопьевск", "Находка", "Рубцовск", "Каменск-Уральский", "Миасс", "Рыбинск", "Норильск", "Псков", "Березники", "Королев", "Абакан", "Каспийск", "Новочеркасск", "Елец", "Уссурийск", "Новомосковск", "Златоуст", "Элиста", "Камышин"
        };
        String[] streets = {
                "Ленина", "Советская", "Мира", "Школьная", "Садовая", "Центральная", "Новая", "Гагарина", "Октябрьская", "Кирова", "Пушкина", "Молодежная", "Заводская", "Полевая", "Зеленая", "Лесная", "Комсомольская", "Первомайская", "Набережная", "Колхозная", "Северная", "Южная", "Горького", "Фрунзе", "Строительная", "Парковая", "Железнодорожная", "Чапаева", "Пролетарская", "Красная", "Береговая", "Рабочая", "Луговая", "Озерная", "Спортивная", "Энергетиков", "Степная", "Мичурина", "Трудовая", "Дорожная", "Пионерская", "Тургенева", "Восточная", "Западная", "Гоголя", "Дружбы", "Больничная", "Речная", "Солнечная", "Интернациональная", "Вокзальная", "Свердлова", "Лермонтова", "Больничная", "Фабричная", "Радужная", "Уральская", "Победы", "Привокзальная", "Маяковского", "Гагарина", "Вишневая", "8 Марта", "50 лет Октября", "Московская", "Тихая", "Ольховая", "Лесхозная", "Майская", "Кольцевая", "Гвардейская", "Юбилейная", "Сиреневая", "Международная", "Сосновая", "Молодежи", "Песчаная", "Весенняя", "Станционная", "Бульварная", "Есенина", "Строителей", "Лазо", "Чкалова", "Урицкого", "Толстого", "Куйбышева", "Ключевая", "Красногвардейская", "Ленинградская", "Ивановская", "Воронежская", "Яблоневая", "Дзержинского", "Матросова"
        };
        String[] corpus = {
                "А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Э", "Ю", "Я"
        };

        User user = new User(
                lastName[(int) (Math.random() * lastName.length)] + " " +
                        firstName[(int) (Math.random() * firstName.length)] + " " +
                        patronymic[(int) (Math.random() * patronymic.length)],
                generateRandomDate(),
                "г. " +  cities[(int) (Math.random() * cities.length)] +
                        ", ул. " + streets[(int) (Math.random() * streets.length)] +
                        ", д. " + (int) (Math.random() * 1000) +
                        ", корпус " + corpus[(int) (Math.random()* corpus.length)] +
                        ", кв. " + (int) (Math.random()* 100)
        );
        return user;
    }


    public static Date generateRandomDate() {
        LocalDate startDate = LocalDate.now().minusYears(50); // 50 лет назад от текущей даты
        LocalDate endDate = LocalDate.now(); // Текущая дата

        long startEpochDay = startDate.toEpochDay();
        long endEpochDay = endDate.toEpochDay();

        long randomEpochDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay + 1);

        LocalDate randomDate = LocalDate.ofEpochDay(randomEpochDay);
        return Date.valueOf(randomDate);
    }
}
