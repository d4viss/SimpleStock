alter table subscription drop column start_date;

alter table subscription drop column finish_date;

alter table subscription_user add column start_date datetime not null;

alter table subscription_user add column finish_date datetime not null;