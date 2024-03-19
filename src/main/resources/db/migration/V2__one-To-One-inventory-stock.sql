alter table inventory add column idstock int;

alter table inventory add constraint fk_inventory_stock foreign key(idstock) references stock(idstock);