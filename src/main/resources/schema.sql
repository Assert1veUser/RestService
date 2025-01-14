CREATE TABLE Restposition (
id uuid PRIMARY KEY,
name VARCHAR(255) NULL,
salary INTEGER NULL
);
CREATE TABLE Reststuff (
id uuid PRIMARY KEY,
surname VARCHAR(255) NULL,
name VARCHAR(255) NULL,
patronymic VARCHAR(255) NULL,
sex BOOLEAN NULL,
birth_date DATE NULL,
salary_multiplier DOUBLE NULL,
position_id uuid NOT NULL,
FOREIGN KEY (position_id) REFERENCES Restposition(id)
);
CREATE TABLE Restoffice (
id uuid PRIMARY KEY,
name VARCHAR(255) NULL,
address VARCHAR(255) NULL,
law_address VARCHAR(255) NULL,
cabinets_count INTEGER NULL
);
CREATE TABLE Restclient (
id UUID PRIMARY KEY,
surname VARCHAR(225),
name VARCHAR(255),
patronymic VARCHAR(255),
sex BOOLEAN,
birth_date DATE,
inn VARCHAR(255),
passport_serial VARCHAR(255),
phone VARCHAR
);
CREATE TABLE Restoffer (
id uuid PRIMARY KEY,
serial_numbers VARCHAR(225) NULL,
sign_date Date NULL,
ending_date Date NULL,
start_date Date NULL,
stuff_id uuid NOT NULL,
client_id uuid NOT NULL,
office_id uuid NOT NULL,
FOREIGN KEY (stuff_id) REFERENCES Reststuff(id),
FOREIGN KEY (client_id) REFERENCES Restclient(id),
FOREIGN KEY (office_id) REFERENCES Restoffice(id)
);