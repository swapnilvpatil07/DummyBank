Dummy Bank

Prerequisite
MySql version 5 or above.
Create schema 'dummy_bank' on database.

Run the application. all the tables automatically will be created on database.
then goto database and look for 'customer_info' table where you will find different users have already been added.
update any row of user with the details you have added to 'web_wallet' while sign up.

e.g:
Data inserted in 'customer_info' table from 'dummy_bank' database.

sample data: 
# cust_id, address, cust_cnt_no, cust_email, cust_name
'33', '3765 Burdette Mountain Suite 044', '8698484304', 'email@gmail.com', 'Swapnil Patil'


& same will be inserted in table 'user_info' from database 'web_wallet'
sample data:

# cust_id, address, cnt_verified, contact_no, dob, email_id, email_verified, f_name, l_name
'177', '', '0', '8698484304', '', 'email@gmail.com', '0', 'Swapnil', 'Patil'
