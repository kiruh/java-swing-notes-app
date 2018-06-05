DROP TABLE Note IF EXISTS;
CREATE TABLE Note (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    text VARCHAR NOT NULL,
    createdAt TIMESTAMP NOT NULL,
    updatedAt TIMESTAMP NOT NULL,
);

DROP TABLE Tag IF EXISTS;
CREATE TABLE Tag (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    value VARCHAR(255) NOT NULL,
);

DROP TABLE NoteTag IF EXISTS;
CREATE TABLE NoteTag (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    noteId INT NOT NULL,
    tagId INT NOT NULL,
    FOREIGN KEY (noteId) REFERENCES Note(id),
    FOREIGN KEY (tagId) REFERENCES Tag(id),
);

INSERT INTO Note (id, title, text, createdAt, updatedAt) VALUES
(1, 'Note 1', 'Note 1 Text', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
(2, 'Note 2', 'Note 2 Text', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
(3, 'Note 3', 'Note 3 Text', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
(4, 'Note 4', 'Note 4 Text', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
(5, 'Note 5', 'Note 5 Text', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
(6, 'Note 6', 'Note 6 Text', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
(7, 'Note 7', 'Note 7 Text', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO Tag (id, value) VALUES
(1, 'important!'),
(2, 'thoughts'),
(3, 'education'),
(4, 'work'),
(5, 'recipes'),
(6, 'events'),
(7, 'parents');

INSERT INTO NoteTag (noteId, tagId) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7);
