-- 코드를 입력하세요
SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE, "%Y-%m-%d") as PUBLISHED_DATE 
FROM BOOK
WHERE CATEGORY = '인문'
and PUBLISHED_DATE like "2021%"
ORDER BY BOOK_ID ASC;