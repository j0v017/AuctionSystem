# SpringBootApp

initiate sale, purchase and bid for a product
Put a new product on auction with starting bid price.
Bid for the product.
Update the bid price.
Enlisting of bids placed on any product

Java Spring boot

Product-
	Product Name(not null, 5 to 30 char)
	Short Description
	Detailed Description
	Category
 a.	Painting
 b.	Sculptor
 c.	Ornament
	Starting Price (Number)
	Bid end date - future date - custom exception 'not future date'

Seller-
	First Name(not null, 5 to 30 char)
	Last Name(not null, 3 to 25 char)
	Address
	City
	State
	Pin
	Phone(not null, 10 digit)
	Email(not null, 5 to 30 char, @)
can delete product('after bid end' and 'already bid' exceptions)

Buyer-
bid for product
seller fields+ ProductId(get from db), Bid Amount
bid after end date exception
multiple bid for same product by same email exception
list of bids received on product (API must return the product details (Short Description, Detailed Description, Category, starting price, Bid End Date) along with all bids placed on it.Descendig on bid amount )
update bid amount(after bid end exception)

API:
/e-auction/
seller
1. add-product
http://localhost:8080/eAuction/seller/add-product
2. delete
http://localhost:8080/eAuction/seller/delete/1
2. show-bids
http://localhost:8080/eAuction/seller/show-bids/1
(Fetches details of all bids on product with product details)

buyer
1. place-bid
http://localhost:8080/eAuction/buyer/place-bid
2. update-bid
   productId
   emailId
   newBidAmount
http://localhost:8080/eAuction/buyer/update-bid/1/abcdexyz@wells.com/9999954777

