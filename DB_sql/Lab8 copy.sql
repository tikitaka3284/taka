/*

*/


/*1. Display the TID, CustomerName, and TDate of sales transactions that a customer bought a product whose ProductName is Dura Boot. (This query is from Lab6 that you did it by Cartesian Product and we want to re-write it using INNER JOIN (or simply JOIN). We must get the same result as lab6-query1 even though we write the query using INNER JOIN)*/


SELECT ST.TID, C.CustomerName, ST.TDate
FROM Customer C
INNER JOIN SalesTransaction ST
ON c.customerID = st.customerID
INNER JOIN SoldVia SV
ON ST.TID = SV.TID
INNER JOIN Product p
ON p.productID = sv.productid
WHERE p.productname = 'Dura Boot'

/* --------------------------------------------------------------------------------------------------
2. Re-Write Query 1 using NATURAL JOIN. (Make sure you get the same result as query 1)----------------------------------------------------------------------------------------------------*/
SELECT TID, CustomerName, TDate
FROM Customer C
NATURAL JOIN SalesTransaction ST

NATURAL JOIN SoldVia SV

NATURAL JOIN Product p

WHERE p.productname = 'Dura Boot'

/* --------------------------------------------------------------------------------------------------
3.  Re-Write Query 1 using CROSS JOIN. (Make sure you get the same result as query 1) 
----------------------------------------------------------------------------------------------------*/

SELECT c.customername, table2.tid, table2.tdate
FROM
(
SELECT distinct st.customerid, tdate, st.tid
FROM Salestransaction ST
CROSS JOIN
(
SELECT distinct TID
FROM Product p
CROSS JOIN soldvia
WHERE p.productname = 'Dura Boot' AND p.productID = soldvia.productID) table1
WHERE table1.TID = ST.tid
) table2
CROSS JOIN Customer c
WHERE c.customerID = table2.customerid

/* --------------------------------------------------------------------------------------------------
4. Display all Regions and StoreIDs in each region. If there is a region where there is no store in it, we still want to see the name of that region on the result (Count how many rows are displayed as a result of this query (17?) and make sure you see that there are 3 regions where there is no store in them (StoreID in the second column of the result is null )) Hint: use LEFT JOIN
----------------------------------------------------------------------------------------------------*/
SELECT Region.regionname, store.storeID
FROM Region
LEFT JOIN store
ON region.regionid = store.regionid

/* --------------------------------------------------------------------------------------------------
5. Re-write query 4 such that the query result displays only regions where there are stores in it. (Count how many rows are displayed as a result of this query (17-3=14?) and make sure you Do NOT see those 3 regions where there is no store in them. Hint: use INNER JOIN
----------------------------------------------------------------------------------------------------*/

SELECT Region.regionname, store.storeID
FROM Region
INNER JOIN store
ON region.regionid = store.regionid
/* --------------------------------------------------------------------------------------------------
6. Re-Write query 5 using RIGHT JOIN. Do you get the same result as query 5? Why? 
----------------------------------------------------------------------------------------------------*/
SELECT Region.regionname, store.storeID
FROM Region
RIGHT JOIN store
ON region.regionid = store.regionid

/*We get the same results because every item in store has overlap with every item in region. If there was a store without a region it would show up in this one but not in the inner join or left join. */

/* --------------------------------------------------------------------------------------------------
7. Display ProductID and ProductName of all products that were not sold. (Hint: You must join Product and SoldVia tables and find the products that their TID is NULL (You must find what type of JOIN must be used in this case. You must see 3 products that were not sold) )
----------------------------------------------------------------------------------------------------*/
SELECT product.productname, product.productID
FROM product
LEFT OUTER JOIN soldvia
on product.productid = soldvia.productid
WHERE SOLDVIA.productID IS NULL


/* --------------------------------------------------------------------------------------------------
8. This query is on HAFH database. Display CCID and CCName of all CorpClients and AptNo and BuildingID of All apartments. We are interested to see all CorpClients even though they did not lease any apartment and also we are interested to see all apartments even though no body leased them. Hint: use FULL JOIN (Make sure you see many null values in the result because B1 and B2 were not leased by any CorpClient and C888 and C333 never rented any apartment)
----------------------------------------------------------------------------------------------------*/
SELECT Corp.ccid, Corp.ccname, apt.aptno, apt.buildingID
FROM corpclient corp
FULL JOIN apartment apt
ON corp.CCID = apt.CCID
