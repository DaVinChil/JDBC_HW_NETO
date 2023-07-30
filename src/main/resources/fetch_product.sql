select product_name
from homework.ORDERS
         join homework.CUSTOMERS
              on homework.CUSTOMERS.id = homework.ORDERS.customer_id
where LOWER(name) = :customer_name;
