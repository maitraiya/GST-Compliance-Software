# GST-Compliance-Software

Prerequisite :-

Need a MySQL Database in PC.
Need to have username and password as root respectively.
Need to fire the following command before execution of Main page i.e Home.java

mysql> delimiter //
mysql> create trigger trig after delete on bill
mysql> for each row begin
mysql> insert into stock(pid,pname,pprice,pqty,pcat,date) values(old.pid,old.pname,old.pprice,old.pqty,old.pcat,sysdate());
mysql> end;
mysql> delimiter;
