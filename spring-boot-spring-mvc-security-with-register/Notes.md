## NOTES
- If you want JDBC support for users and roles __out-of-the-box__, you need these 2 tables with the exact same names and format
  - users: __username__(varchar(50)), __password__(varchar(50)), __enabled__(tinyint(1))
  - authorities: __username__(varchar(50)), __authority__(varchar(50))

```sql
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL PRIMARY KEY,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint NOT NULL, 
PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

```sql
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
    CONSTRAINT `authorities_ibfk_1` 
    FOREIGN KEY (`username`) 
    REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
- If we want to use custom tables, for e.g. members and roles, we need to implement our own UserDetailsService
- 


