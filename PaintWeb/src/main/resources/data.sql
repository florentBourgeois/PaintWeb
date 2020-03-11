-- generate some shapes to test the jpa implementation.

-- pixel tests : enable to test the inheritance with sshape
INSERT INTO sshape VALUES(2002, 1);
INSERT INTO spixel VALUES(7, 4, 2002);



INSERT INTO sshape VALUES(2003, 1);
INSERT INTO spixel VALUES(0, 0, 2003);

INSERT INTO sshape VALUES(2004, 1);
INSERT INTO spixel VALUES(7000, 104, 2004);


-- rectangle tests : enable to test the composition with another object (pixel)
INSERT INTO sshape VALUES(3000, 0);
INSERT INTO spixel VALUES(999, 999, 3000);
INSERT INTO sshape VALUES(3001, 0);
INSERT INTO srectangle VALUES(10, 100, 3001, 3000);



-- scircle test
INSERT INTO sshape VALUES(4000, 0);
INSERT INTO spixel VALUES(1, 1, 4000);
INSERT INTO sshape VALUES(4001, 0);
INSERT INTO scircle VALUES(4, 4001, 4000);


-- ssquare tests : enable to test the inheritance cascade
INSERT INTO sshape VALUES(5000, 0);
INSERT INTO spixel VALUES(50, 50, 5000);
INSERT INTO sshape VALUES(5001, 0);
INSERT INTO srectangle VALUES(500, 5, 5001, 5000);
INSERT INTO ssquare VALUES(5001);




-- sstampon tests : enable to test composit pattern
INSERT INTO sshape VALUES(6000, 0);
INSERT INTO spixel VALUES(50, 50, 6000);
INSERT INTO sshape VALUES(6001, 0);
INSERT INTO spixel VALUES(51, 51, 6001);
INSERT INTO sshape VALUES(6002, 0);
INSERT INTO spixel VALUES(52, 52, 6002);

INSERT INTO sshape VALUES(6003, 0);
INSERT INTO stampon VALUES(6003);
INSERT INTO stampon_shapes VALUES(6003, 6000);
INSERT INTO stampon_shapes VALUES(6003, 6001);
INSERT INTO stampon_shapes VALUES(6003, 6002);
