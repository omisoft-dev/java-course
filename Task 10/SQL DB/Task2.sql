DROP TABLE People;
CREATE TABLE People ( Name varchar(50) NOT NULL, Age int NOT NULL, Email varchar(30) NOT NULL, ID varchar(11) NOT NULL, KeyPeople int(5) DEFAULT '0' NOT NULL, PRIMARY KEY (KeyPeople), CONSTRAINT ID UNIQUE (ID) ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
DROP TABLE People_Trip;
CREATE TABLE People_Trip ( KeyPeople int(5) NOT NULL AUTO_INCREMENT, KeyTrip int(5) NOT NULL, INDEX KeyTrip (KeyTrip), INDEX KeyPeople (KeyPeople) ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
DROP TABLE Trip;
CREATE TABLE Trip ( TicketNumber int(5) NOT NULL, DateOfArival date NOT NULL, DateOfDeparture date NOT NULL, City varchar(30) NOT NULL, KeyTrip int(5) DEFAULT '0' NOT NULL, PRIMARY KEY (KeyTrip), CONSTRAINT TicketNumber UNIQUE (TicketNumber) ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
ALTER TABLE People_Trip ADD FOREIGN KEY (KeyTrip) REFERENCES Trip (KeyTrip) ;
ALTER TABLE People_Trip ADD FOREIGN KEY (KeyPeople) REFERENCES People (KeyPeople);
