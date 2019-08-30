/*


/*1. Display the TID, CustomerName, and TDate of sales transactions that a customer bought a product whose ProductName is Dura Boot. (This query is from Lab6 that you did it by Cartesian Product and we want to re-write it using INNER JOIN (or simply JOIN). We must get the same result as lab6-query1 even though we write the query using INNER JOIN)*/
SELECT Salestransaction.tid, Customer.customername, Salestransaction.tdate
FROM Salestransaction 
INNER JOIN Customer ON Salestransaction.customerid=Customer.customerid
INNER JOIN Soldvia ON Salestransaction.tid=Soldvia.tid
WHERE Soldvia.productid=(SELECT productid FROM Product WHERE productname='Dura Boot');
/*2. Re-Write Query 1 using NATURAL JOIN. (Make sure you get the same result as query 1*/
SELECT tid, Customer.customername, Salestransaction.tdate
FROM Salestransaction

NATURAL INNER JOIN Customer 
NATURAL INNER JOIN Soldvia 
WHERE Soldvia.productid=(SELECT productid FROM Product WHERE productname='Dura Boot');
/*3. Re-Write Query 1 using CROSS JOIN. (Make sure you get the same result as query 1)*/
SELECT Salestransaction.tid, Customer.customername, Salestransaction.tdate
FROM Salestransaction
CROSS JOIN Customer, Soldvia
WHERE Salestransaction.customerid=Customer.customerid AND Salestransaction.tid=Soldvia.tid AND Soldvia.productid=(SELECT Product.productid FROM Product WHERE Product.productname='Dura Boot');

/*4. Display all Regions and StoreIDs in each region. If there is a region where there is no store in it, we still want to
see the name of that region on the result (Count how many rows are displayed as a result of this query (17?) and make sure you see that there are 3 regions where there is no store in them (StoreID in the second column of the result is null )) Hint: use LEFT JOIN*/
SELECT regionname, storeid
FROM  Region LEFT JOIN Store ON Region.regionid=Store.regionid;
/*5. Re-write query 4 such that the query result displays only regions where there are stores in it. (Count how many rows are displayed as a result of this query (17-3=14?) and make sure you Do NOT see those 3 regions where there is no store in them. Hint: use INNER JOIN*/
SELECT regionname, storeid
FROM  Region INNER JOIN Store ON Region.regionid=Store.regionid;
/*6. Re-Write query 5 using RIGHT JOIN. Do you get the same result as query 5? Why? no, it is
not same. because query 5 is using INNER JOIN, it is more restricted and things depending on are different from query6 */
SELECT regionname, storeid
FROM  Region RIGHT JOIN Store ON Region.regionid=Store.regionid;
/*7. Display ProductID and ProductName of all products that were not sold. (Hint: You must join Product and SoldVia
tables and find the products that their TID is NULL (You must find what type of JOIN must be used in this case. You must see 3 products that were not sold) */
SELECT Product.productid, Product.productname
FROM Product LEFT JOIN Soldvia ON Product.productid=Soldvia.productid
WHERE Soldvia.tid IS NULL;
/*8. This query is on HAFH database. Display CCID and CCName of all CorpClients and AptNo and BuildingID of All apartments. We are interested to see all CorpClients even though they did not lease any apartment and also we are interested to see all apartments even though no body leased them. Hint: use FULL JOIN (Make sure you see many null values in the result because B1 and B2 were not leased by any CorpClient and C888 and C333 never rented any apartment)*/
SELECT Corpclient.ccid, Corpclient.ccname, Apartment.aptno, Apartment.buildingid
FROM Corpclient FULL JOIN Apartment ON Corpclient.ccid=Apartment.ccid;