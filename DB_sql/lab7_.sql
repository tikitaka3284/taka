/*



/* --------------------------------------------------------------------------------------------------
1. Display the TID, CustomerName, and TDate for sales transactions 
    involving a customer buying a product whose ProductName is Dura Boot. 
----------------------------------------------------------------------------------------------------*/

SELECT Salestransaction.tid, Customer.customername, Salestransaction.tdate, Product.productname
FROM Salestransaction, Customer, Product, Soldvia
WHERE Product.productid=Soldvia.productid AND Soldvia.tid=SalesTransaction.tid
AND Product.productname='Dura Boot'AND Salestransaction.customerid=Customer.customerid;

/* --------------------------------------------------------------------------------------------------
2. Display the ProductID and ProductName of the cheapest product. 
----------------------------------------------------------------------------------------------------*/
SELECT productid, productname
FROM Product
WHERE productprice = (SELECT MIN(productprice) FROM Product);

/* --------------------------------------------------------------------------------------------------
3. Display the ProductID, ProductName, and VendorName for products 
    whose price is below the average price of all products. 
----------------------------------------------------------------------------------------------------*/
SELECT productid, productname, vendorname
FROM Product, Vendor
WHERE Product.vendorid=Vendor.vendorid AND productprice < ALL(SELECT AVG(productprice) FROM Product);

/* --------------------------------------------------------------------------------------------------
4. Display the CustomerName and the average of product price for each customer. 
----------------------------------------------------------------------------------------------------*/
SELECT 
    customername, AVG(productprice)
FROM
    Customer,
    Product,
    Soldvia,
    Salestransaction
WHERE
    Product.productid = Soldvia.productid
        AND Soldvia.tid = Salestransaction.tid
        AND Salestransaction.customerid = Customer.customerid
GROUP BY customername;


/* --------------------------------------------------------------------------------------------------
5. Display the CustomerName who purchased products having price greater 
    than the average of each customer purchase.
----------------------------------------------------------------------------------------------------*/
SELECT customername
FROM Customer, Product, Soldvia, Salestransaction
WHERE Product.productid=Soldvia.productid AND 
Soldvia.tid=Salestransaction.tid AND 
Salestransaction.customerid=Customer.customerid AND
productprice > ALL(SELECT AVG(Productprice) FROM Product)
GROUP BY customername;


/* --------------------------------------------------------------------------------------------------
6. Display the ProductID for the product that has been sold the most 
    (i.e., that has been sold in the highest quantity). 
----------------------------------------------------------------------------------------------------*/
SELECT productid
FROM Soldvia
WHERE NoOfItems = ALL(SELECT MAX(NoOfItems) FROM Soldvia);

/* --------------------------------------------------------------------------------------------------
7. Display the RegionID, RegionName, and number of stores in the region for all regions. 
    Sort the results by number of stores from greatest to least. 
----------------------------------------------------------------------------------------------------*/

SELECT r.regionid, r.regionname, COUNT(*)
FROM Store s, Region r
WHERE r.regionid=s.regionid
GROUP BY r.regionid, r.regionname
ORDER BY COUNT(*) DESC;
/* --------------------------------------------------------------------------------------------------
8. Retrieve the product ID, product name, and product price for each product that has 
    more than three items sold within all sales transactions or whose items were sold 
    in more than one sales transaction (Hint: UNION)
----------------------------------------------------------------------------------------------------*/

CREATE VIEW Products_more_than_3_sold AS
SELECT productid, productname, productprice
FROM Product
WHERE Productid IN (SELECT productid FROM Soldvia GROUP BY productid HAVING SUM(noofitems)>3)
UNION 
SELECT productid, productname, productprice FROM product;
/* --------------------------------------------------------------------------------------------------
9. Retrieve the product ID, product name, and product price for each product that has 
    more than three items sold within all sales transactions and whose items were sold 
    in more than one sales transaction. (Hint: INTERSECTS)
----------------------------------------------------------------------------------------------------*/


/* --------------------------------------------------------------------------------------------------
10. Retrieve the product ID, product name, and product price for each product that has 
    more than three items sold within all sales transactions but whose items 
    were not sold in more than one sales transaction. (Hint: MINUS)
----------------------------------------------------------------------------------------------------*/



/* --------------------------------------------------------------------------------------------------
11. Update the manager table so that table look like below:
-----------------------------------------------------------------------------------------------------
|   MANAGERID   |   MFNAME  |   MLNAME  |   MBDATE      |   MSALARY |   MBONUS  |   MRESBUILDINGID  |
|---------------|-----------|-----------|---------------|-----------|-----------|-------------------|
|   M12         |   Boris   |   Grant   |   01/04/1980  |   60000   |   -       |   B1              |
|   M23         |   Austin  |   Lee     |   02/05/1975  |   50000   |   5000    |   B2              |
|   M34         |   George  |   Sherman |   12/06/1978  |   52000   |   2000    |   B4              |
-----------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------*/
SELECT managerid, mfname, mlname, mbdate, msalary, mbonus, mresbuildingid
FROM Manager;

/* --------------------------------------------------------------------------------------------------
12. Display the MFName, MLName, MSalary, MBDate, and number of buildings that the 
    manager manages for all managers with a salary less than $55,000.
----------------------------------------------------------------------------------------------------*/
SELECT mfname, mlname, msalary, mbdate, mresbuildingid
FROM Manager
WHERE msalary < 55000;

/* --------------------------------------------------------------------------------------------------
13. Display the BuildingID and AptNo, for all apartments leased by the corporate client WindyCT.
----------------------------------------------------------------------------------------------------*/

SELECT buildingid, aptno
FROM Apartment, Corpclient
WHERE Apartment.ccid=Corpclient.ccid AND Corpclient.ccname ='WindyCT';
/* --------------------------------------------------------------------------------------------------
14. Display the SMemberID and SMemberName of staff members cleaning apartments 
    rented by corporate clients whose corporate location is Chicago. Do not 
    display the same information more than once.
----------------------------------------------------------------------------------------------------*/
SELECT Staffmember.smemberid, Staffmember.smembername
FROM Staffmember, Cleaning, Apartment, Corpclient
WHERE Staffmember.smemberid=Cleaning.smemberid AND Cleaning.buildingid=Apartment.buildingid AND Apartment.ccid=Corpclient.ccid AND cclocation='Chicago';

/* --------------------------------------------------------------------------------------------------
15. Display the CCName of the client and the CCName of the client who referred it, 
    for every client referred by a client in the music industry.
----------------------------------------------------------------------------------------------------*/

SELECT ccname
FROM Corpclient
WHERE ccidreferredby ='Mus%';
/* --------------------------------------------------------------------------------------------------
16. Display the BuildingID, AptNo, and ANoOfBedrooms for all apartments that are not leased.
----------------------------------------------------------------------------------------------------*/
SELECt buildingid, aptno, anoofbedrooms
FROM Apartment
WHERE anoofbedrooms IS NULL;

