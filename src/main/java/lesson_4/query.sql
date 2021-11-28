/*ошибки в расписании*/
SELECT f1.name as "фильм_1",
       s1.session_time as "время начала",
       f1.duration as "длительность",
       f2.name as "фильм_2",
       s2.session_time as "время начала",
       f2.duration as "длительность"
FROM cinema.sessions as s1 JOIN cinema.sessions as s2
ON s1.id<>s2.id AND s1.session_time<=s2.session_time AND s2.session_time<=(s1.session_time+f1.duration)
join cinema.films as f1
on f1.id=s1.id_film
join cinema.films as f2
on f2.id=s2.id_film
ORDER BY s1.session_time;

/*перерывы 30 минут и более между фильмами*/