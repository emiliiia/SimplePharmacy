INSERT INTO roles (roleName)
VALUES
    ('Admin'),
    ('Manager'),
    ('User');

INSERT INTO users (user_name, user_date_birth, user_phone_num, user_email, role_id)
VALUES
    ( 'emilia', '2022-09-01', '+38050572122', 'emilia@chnu.edu.ua', 1),
    ( 'yulia', '2022-09-01', '552482', 'yuliana@chnu.edu.ua', 2),
    ( 'helen', '2022-09-01', '+380505489725', 'helen@chnu.edu.ua', 3);
