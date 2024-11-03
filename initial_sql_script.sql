insert into products (ingredient_name, volume_type, unit) VALUES ('WATER', 'ML', 300);
insert into products (ingredient_name, volume_type, unit) VALUES ('COFFEE', 'MG', 100);
insert into products (ingredient_name, volume_type, unit) VALUES ('MILK', 'ML', 200);


insert into coffee (name) values ('Espresso');
insert into coffee (name) values ('Americano');
insert into coffee (name) values ('Cappuccino');

insert into coffee_ingredients (ingredient_name, unit, coffee_id) VALUES ('WATER', 35, (select c.id from coffee as c where c.name = 'Espresso'));
insert into coffee_ingredients (ingredient_name, unit, coffee_id) VALUES ('COFFEE', 10, (select c.id from coffee as c where c.name = 'Espresso'));

insert into coffee_ingredients (ingredient_name, unit, coffee_id) VALUES ('WATER', 70, (select c.id from coffee as c where c.name = 'Americano'));
insert into coffee_ingredients (ingredient_name, unit, coffee_id) VALUES ('COFFEE', 10, (select c.id from coffee as c where c.name = 'Americano'));

insert into coffee_ingredients (ingredient_name, unit, coffee_id) VALUES ('WATER', 10, (select c.id from coffee as c where c.name = 'Cappuccino'));
insert into coffee_ingredients (ingredient_name, unit, coffee_id) VALUES ('MILK', 5, (select c.id from coffee as c where c.name = 'Cappuccino'));
insert into coffee_ingredients (ingredient_name, unit, coffee_id) VALUES ('COFFEE', 3, (select c.id from coffee as c where c.name = 'Cappuccino'));

commit;
