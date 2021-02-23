CREATE TABLE USERS
(
   ID SERIAL PRIMARY KEY,
   FIRSTNAME VARCHAR(100),
   LASTNAME	VARCHAR(100)
);

CREATE TABLE POSTS
(
   ID  SERIAL PRIMARY KEY,
   USER_ID  BIGINT UNSIGNED NOT NULL,
   BODY   VARCHAR(1024),
   FOREIGN KEY (USER_ID) REFERENCES USERS(ID)
);

CREATE TABLE ISSUESLISTS (
    ID SERIAL PRIMARY KEY,
    NAME VARCHAR(100)
);

CREATE TABLE ISSUES
(
	ID SERIAL PRIMARY KEY,
    ISSUESLIST_ID BIGINT UNSIGNED NOT NULL,
    SUMMARY VARCHAR(100),
    DESCRIPTION VARCHAR(1000),
    USER_ID_ASSIGNEDTO BIGINT UNSIGNED NOT NULL,
		
	FOREIGN KEY (ISSUESLIST_ID) REFERENCES ISSUESLISTS(ID),
    FOREIGN KEY (USER_ID_ASSIGNEDTO) REFERENCES USERS(ID)
);

INSERT INTO USERS (FIRSTNAME, LASTNAME)
VALUES ("John", "Smith");

INSERT INTO USERS (FIRSTNAME, LASTNAME)
VALUES ("Zachary", "Lee");

INSERT INTO USERS (FIRSTNAME, LASTNAME)
VALUES ("Stephanie", "Kovalsky");

INSERT INTO USERS (FIRSTNAME, LASTNAME)
VALUES ("Thomas", "Landgren");

INSERT INTO USERS (FIRSTNAME, LASTNAME)
VALUES ("John", "Thomson");

INSERT INTO POSTS (USER_ID, BODY)
VALUES (1, "This is my first post on this forum!");

INSERT INTO POSTS (USER_ID, BODY)
VALUES (2, "This is my first post too!");

INSERT INTO POSTS (USER_ID, BODY)
VALUES (2, "How are you?");

INSERT INTO POSTS (USER_ID, BODY)
VALUES (1, "Quite good, thanks bro!");

INSERT INTO POSTS (USER_ID, BODY)
VALUES (4, "Yo all! Here is Thomas!");

INSERT INTO ISSUESLISTS(NAME)
VALUES ("To Do"); 

INSERT INTO ISSUESLISTS(NAME)
VALUES ("In Progress"); 

INSERT INTO ISSUESLISTS(NAME)
VALUES ("Done"); 

INSERT INTO ISSUES(ISSUESLIST_ID,SUMMARY,DESCRIPTION,USER_ID_ASSIGNEDTO)
VALUES (1,"Task 1", "DESCRIPTION",1); 

INSERT INTO ISSUES(ISSUESLIST_ID,SUMMARY,DESCRIPTION,USER_ID_ASSIGNEDTO)
VALUES (1,"Task 2", "DESCRIPTION",1); 

INSERT INTO ISSUES(ISSUESLIST_ID,SUMMARY,DESCRIPTION,USER_ID_ASSIGNEDTO)
VALUES (1,"Task 3", "DESCRIPTION",1); 

INSERT INTO ISSUES(ISSUESLIST_ID,SUMMARY,DESCRIPTION,USER_ID_ASSIGNEDTO)
VALUES (1,"Task 4", "DESCRIPTION",2); 

INSERT INTO ISSUES(ISSUESLIST_ID,SUMMARY,DESCRIPTION,USER_ID_ASSIGNEDTO)
VALUES (1,"Task 5", "DESCRIPTION",3); 

INSERT INTO ISSUES(ISSUESLIST_ID,SUMMARY,DESCRIPTION,USER_ID_ASSIGNEDTO)
VALUES (1,"Task 1", "DESCRIPTION",1); 

INSERT INTO ISSUES(ISSUESLIST_ID,SUMMARY,DESCRIPTION,USER_ID_ASSIGNEDTO)
VALUES (1,"Task 2", "DESCRIPTION",1); 

INSERT INTO ISSUES(ISSUESLIST_ID,SUMMARY,DESCRIPTION,USER_ID_ASSIGNEDTO)
VALUES (1,"Task 3", "DESCRIPTION",1); 

INSERT INTO ISSUES(ISSUESLIST_ID,SUMMARY,DESCRIPTION,USER_ID_ASSIGNEDTO)
VALUES (1,"Task 4", "DESCRIPTION",2); 

INSERT INTO ISSUES(ISSUESLIST_ID,SUMMARY,DESCRIPTION,USER_ID_ASSIGNEDTO)
VALUES (1,"Task 5", "DESCRIPTION",3); 

INSERT INTO ISSUES(ISSUESLIST_ID,SUMMARY,DESCRIPTION,USER_ID_ASSIGNEDTO)
VALUES (2,"Task 6", "DESCRIPTION",4); 

INSERT INTO ISSUES(ISSUESLIST_ID,SUMMARY,DESCRIPTION,USER_ID_ASSIGNEDTO)
VALUES (2,"Task 7", "DESCRIPTION",4); 

INSERT INTO ISSUES(ISSUESLIST_ID,SUMMARY,DESCRIPTION,USER_ID_ASSIGNEDTO)
VALUES (2,"Task 8", "DESCRIPTION",4); 

INSERT INTO ISSUES(ISSUESLIST_ID,SUMMARY,DESCRIPTION,USER_ID_ASSIGNEDTO)
VALUES (2,"Task 9", "DESCRIPTION",2); 

INSERT INTO ISSUES(ISSUESLIST_ID,SUMMARY,DESCRIPTION,USER_ID_ASSIGNEDTO)
VALUES (2,"Task 10", "DESCRIPTION",3); 

INSERT INTO ISSUES(ISSUESLIST_ID,SUMMARY,DESCRIPTION,USER_ID_ASSIGNEDTO)
VALUES (3,"Task 11", "DESCRIPTION",3); 

INSERT INTO ISSUES(ISSUESLIST_ID,SUMMARY,DESCRIPTION,USER_ID_ASSIGNEDTO)
VALUES (3,"Task 12", "DESCRIPTION",2); 

INSERT INTO ISSUES(ISSUESLIST_ID,SUMMARY,DESCRIPTION,USER_ID_ASSIGNEDTO)
VALUES (3,"Task 13", "DESCRIPTION",1); 

INSERT INTO ISSUES(ISSUESLIST_ID,SUMMARY,DESCRIPTION,USER_ID_ASSIGNEDTO)
VALUES (3,"Task 14", "DESCRIPTION",2); 

INSERT INTO ISSUES(ISSUESLIST_ID,SUMMARY,DESCRIPTION,USER_ID_ASSIGNEDTO)
VALUES (3,"Task 15", "DESCRIPTION",1); 

SELECT * FROM ISSUES;