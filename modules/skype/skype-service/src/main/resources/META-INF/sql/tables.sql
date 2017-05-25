create table rivetlogic_skype_SkypeGroup (
	skypeGroupId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	groupName VARCHAR(75) null,
	skypeContacts VARCHAR(75) null
);