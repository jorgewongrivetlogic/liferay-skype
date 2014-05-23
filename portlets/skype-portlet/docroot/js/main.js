/**
 * Copyright (C) 2005-2014 Rivet Logic Corporation.
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; version 3 of the License.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */

AUI.add('skype-portlet', function (Y, NAME) {
    Y.Skype = Y.Base.create('skype-portlet', Y.Base, [], {
        html: "",
        dataTable: {},
        data: {},
        searchKeyword: '',
        currentPage: 1,
        total: 0,
        nameAsc: true,
        lastNameAsc: false,
        isOrderedName: true,
        isOrderedLastName: false,
        itemsOnPaginator: 15,
        groupsPaginator: null,
        usersPaginator: null,

/** -------------------------------- AJAX CALLS ---------------------------------/*
/**
 *  Executes an ajax call
 * 
 */
        executeAjax: function (configuration, callback, responseURL) {
            var url = responseURL ? responseURL : this.get('resourceUrl'),
                me = this;
            Y.io.request(url, {
                method: configuration.method,
                data: configuration.data,
                dataType: 'json',
                on: {
                    success: function (e) {
                        var data = this.get('responseData');
                        me.total = data.total;
                        callback(data);
                    }
                }
            });
        },

        /**
         *  Retrieves the users, using the current usersPerPage (delta) and currentPage.
         *  After retrieving the data, checks if data is ordered (by name or last name),
         *  and if it is, whether is ascending or descending order, to add the correspondant
         *  properties to the json that renders the table (so that it prints the arrows
         *  on the table header).
         *
         */
        listUsersCall: function () {
            var me = this,
                rawData = {
                    skypecmd: 'list-users',
                    delta: me.get('usersPerPage'),
                    curPage: me.currentPage
                };
            if (me.searchKeyword != '') {
                rawData.search = me.searchKeyword;
            }
            // Verify whether the user has ordered the columns so that they keep
            // appearing with that order
            if (me.isOrderedName) {
                rawData.orderByCol = 'first-name';
                rawData.isAsc = me.nameAsc;
            } else {
                if (me.isOrderedLastName) {
                    rawData.orderByCol = 'last-name';
                    rawData.isAsc = me.lastNameAsc;
                }
            }
            var data = Liferay.Util.ns(
            this.get('portletNamespace'), rawData);
            this.executeAjax({
                method: 'GET',
                data: data
            }, function (d) {
                if (me.isOrderedName) {
                    d.isOrderedName = me.isOrderedName;
                    if (me.nameAsc) {
                        d.nameAsc = me.nameAsc;
                    }
                }
                if (me.isOrderedLastName) {
                    d.isOrderedLastName = me.isOrderedLastName;
                    if (me.lastNameAsc) {
                        d.lastNameAsc = me.lastNameAsc;
                    }
                }
                me.renderTable(d);
                me.renderPagination(d.total);
            });
        },


        /**
         *  Retrieves the users, but ordered by their first name.
         *  Sets the object variables isOrderedName and nameAsc (if it is set in ascending order)
         *  so that pagination keeps using that order.
         */
        orderByName: function () {
            this.nameAsc = !this.nameAsc;
            var me = this,
                data = Liferay.Util.ns(
                this.get('portletNamespace'), {
                    skypecmd: 'list-users',
                    orderByCol: 'first-name',
                    delta: me.get('usersPerPage'),
                    curPage: me.currentPage,
                    isAsc: me.nameAsc
                });

            this.executeAjax({
                method: 'GET',
                data: data
            }, function (d) {
                d.isOrderedName = true;
                if (me.nameAsc) {
                    d.nameAsc = true;
                }
                me.renderTable(d);
            });
        },

        /**
         *  Retrieves the users, but ordered by their last name.
         *  Sets the object variables isOrderedLastName and lastNameAsc (if it is set in ascending order)
         *  so that pagination keeps using that order.
         */
        orderByLastName: function (callback) {
            this.lastNameAsc = !this.lastNameAsc;
            var me = this,
                data = Liferay.Util.ns(
                this.get('portletNamespace'), {
                    skypecmd: 'list-users',
                    orderByCol: 'last-name',
                    delta: me.get('usersPerPage'),
                    curPage: me.currentPage,
                    isAsc: me.lastNameAsc
                });


            this.executeAjax({
                method: 'GET',
                data: data
            }, function (d) {
                d.isOrderedLastName = true;
                if (me.lastNameAsc) {
                    d.lastNameAsc = true;
                }

                me.renderTable(d);
            });
        },
        
        
        getGroupsPaginated: function (options) {
            var me = this;
            this.getGroups(Liferay.Util.ns(
                this.get('portletNamespace'), {
                    skypecmd: 'list-groups',
                    curPage: options.curPage,
                    delta: me.get('groupsPerPage')
            }));
        },
        
        getGroups: function (options, callback) {
            var me = this,
                data = (options) ? options : Liferay.Util.ns(
                this.get('portletNamespace'), {
                    skypecmd: 'list-groups',
                    delta: me.get('groupsPerPage')
                });
            this.executeAjax({
                method: 'GET',
                data: data
            }, function (groups) {
                if (typeof callback != 'undefined') {
                    callback(groups);
                }
                if (!options) {
                    if (me.groupsPaginator) {
                        me.groupsPaginator.set('total', Math.floor((groups.total + me.get('groupsPerPage') - 1) / me.get('groupsPerPage')));
                        me.groupsPaginator.set('page', 1);
                    }
                }
                me.renderGroupTable(groups);
            });
        },

        addGroup: function (groupName, groupList, cb) {
            var me = this,
                data = Liferay.Util.ns(
                this.get('portletNamespace'), {
                    skypecmd: 'add-group',
                    'skype-group-name': groupName,
                    'ids': Y.JSON.stringify(groupList)
                });
            this.executeAjax({
                method: 'GET',
                data: data
            }, function (d) {
                me.getGroups();
                var exec = (typeof cb != 'undefined') ? cb(d) : null;
            });
        },
        
        updateGroupName: function(groupId, groupName, cb) {
            var me = this,
            data = Liferay.Util.ns(
            this.get('portletNamespace'), {
                skypecmd: 'update-group-name',
                'skype-group-id': groupId,
                'skype-group-name': groupName
            });
            this.executeAjax({
                method: 'GET',
                data: data
            }, function (d) {
                me.getGroups();
                var exec = (typeof cb != 'undefined') ? cb(d) : null;
            });
        },
        
        updateGroup: function (groupId, groupName, groupList, cb) {
            var me = this,
                data = Liferay.Util.ns(
                this.get('portletNamespace'), {
                    skypecmd: 'update-group',
                    'skype-group-id': groupId,
                    'skype-group-name': groupName,
                    'ids': Y.JSON.stringify(groupList)
                });
            this.executeAjax({
                method: 'GET',
                data: data
            }, function (d) {
                me.getGroups();
                var exec = (typeof cb != 'undefined') ? cb(d) : null;
            });
        },

        removeGroup: function (groupId) {
            var me = this,
                data = Liferay.Util.ns(
                this.get('portletNamespace'), {
                    skypecmd: 'remove-group',
                    'skype-group-id': groupId
                });
            this.executeAjax({
                method: 'GET',
                data: data
            }, function (d) {
                me.getGroups();
            });
        }, 

        getGroupInfo: function (skypeGroupId, callback) {
            var data = Liferay.Util.ns(
            this.get('portletNamespace'), {
                skypecmd: 'get-group',
                'skype-group-id': skypeGroupId
            });
            this.executeAjax({
                method: 'GET',
                data: data
            }, function (d) {
                callback(d);
            });
        },

/** -------------------------------- RENDERING FUNCTIONS ---------------------------------/*

        /**
         * Renders the pagination. 
         * 
         */
        renderPagination: function (total) {
        	var me = this,
            	MAX_PAGE_ITEMS = 5;
        	
            if (!this.usersPaginator) {
                this.usersPaginator = new Y.Rivet.Pagination({
                    boundingBox: Y.one('#' + this.pns + 'table-pagination'),
                    total: Math.floor((total + this.get('usersPerPage') - 1) / this.get('usersPerPage')),
                    page: 1,
                    circular: false,
                    maxPagesNavItems: MAX_PAGE_ITEMS,
                    strings: {
                        firstNavLinkText: Liferay.Language.get('skype.pagination.first.label'),
                        lastNavLinkText: Liferay.Language.get('skype.pagination.last.label'),
                        next: Liferay.Language.get('skype.pagination.prev.label'),
                        prev: Liferay.Language.get('skype.pagination.next.label')
                    },
                    after: {
                        changeRequest: function(event) {
                            me.currentPage = event.state.page;
                            me.listUsersCall();
                        }
                    }
                }).render();
            } else {
                this.usersPaginator.set('total', Math.floor((total + me.get('usersPerPage') - 1) / me.get('usersPerPage')));
                this.usersPaginator.set('page', me.currentPage);
            }
        },

        /**
         *
         * Renders the table
         */
        renderTable: function (data) {
            var source = Y.one('#' + this.pns + 'table-template').getHTML(),
                template = Y.Handlebars.compile(source),
                html = template(data);

            Y.one('#' + this.pns + 'users-table').get('childNodes').remove();
            Y.one('#' + this.pns + 'users-table').append(html);

        },

        /**
         *
         * Renders elements on the group list
         */
        renderLi: function (data) {
            if (this.isInList(data.skypeid)) {
                var source = Y.one('#' + this.pns + 'item-template').getHTML(),
                    template = Y.Handlebars.compile(source),
                    html = template(data);

                Y.one('#'+ this.pns + 'users').append(html);
            } else {
                this.showMessage(Liferay.Language.get('error'), Liferay.Language.get('error.message.alredy.in.list'));
            }
        },

        renderGroupTable: function (groups) {
            var MAX_PAGE_ITEMS = 5
            var me = this;
            var source = Y.one('#' + this.pns + 'groups-template').getHTML(),
                template = Y.Handlebars.compile(source),
                html = template(groups);

            Y.one('#' + this.pns + 'groups-list .groups-wrapper').get('childNodes').remove();
            Y.one('#' + this.pns + 'groups-list .groups-wrapper').append(html);
            
            if (!this.groupsPaginator) {
                this.groupsPaginator = new Y.Rivet.Pagination({
                    boundingBox: '#' + this.pns + 'groups-list .groups-pagination',
                    total: Math.floor((groups.total + this.get('groupsPerPage') - 1) / this.get('groupsPerPage')),
                    page: 1,
                    circular: false,
                    maxPagesNavItems: MAX_PAGE_ITEMS,
                    strings: {
                        firstNavLinkText: Liferay.Language.get('skype.pagination.first.label'),
                        lastNavLinkText: Liferay.Language.get('skype.pagination.last.label'),
                        next: Liferay.Language.get('skype.pagination.prev.label'),
                        prev: Liferay.Language.get('skype.pagination.next.label')
                    },
                    after: {
                        changeRequest: function(event) {
                            me.getGroupsPaginated({curPage: event.state.page});
                        }
                    }
                }).render();
            }
        },

        updateGroupRender: function (paramData) {
            var data = paramData["group-info"],
                length = data.ids.length,
                me = this;
            Y.one('#' + this.pns + 'group-name span').set("text", data["skype-group-name"]);
            Y.one('#' + this.pns + 'group-name span').setAttribute("group-id", data["skype-group-id"]);
            Y.one('#' + this.pns + 'users').get("childNodes").remove();

            for (var i = 0; i < length; i++) {
                var item = data.ids[i];
                if (item["is-skype"]) {
                    item.type = "skype";
                    item.skypeid = item["skype-sn"];
                } else {
                    item.type = "phone";
                    item.skypeid = item["primary-phone"];
                }
                me.renderLi(data.ids[i]);
            }

        },

        /**
         *    Given an element (a node with a title), a name (a string containing the text to be added)
         *   and a type (whether skype or phone), adds a new element to the list of users to be called.
         *
         */


/** -------------------------------- LISTENERS ---------------------------------/*

        /**
        *   Adds the user of the currently clicked element to the list of
        *    users to call. Specific for skype icon
        *
        */
        setSkypeListener: function () {
            var me = this;
            Y.one('#' + this.pns + 'users-table').delegate('click', function (e) {
                Y.all(".skype-portlet .portlet-msg-error").setStyle("display", "none");
                var lastNameNode = e.currentTarget.get("parentNode").previous(),
                    lastname = lastNameNode.get("text"),
                    name = lastNameNode.previous().get("text");
                me.renderLi({
                    type: "skype",
                    "last-name": lastname,
                    "first-name": name,
                    skypeid: e.currentTarget.get("title"),
                    "user-id": e.currentTarget.getAttribute("user")
                });
                me.get('container').one('.group-save-btn').removeClass('disabled');
                Y.one('#' + me.pns + 'group-name').removeClass('hidden');
            }, ".icon-skype");
        },

        /**
         *   Adds the user of the currently clicked element to the list of
         *    users to call. Specific for skype icon
         *
         */
        setPhoneListener: function () {
            var me = this;
            Y.one('#' + this.pns + 'users-table').delegate("click", function (e) {
                Y.all(".skype-portlet .portlet-msg-error").setStyle("display", "none");
                var lastNameNode = e.currentTarget.get("parentNode").previous().previous(),
                    lastname = lastNameNode.get("text"),
                    name = lastNameNode.previous().get("text");

                me.renderLi({
                    type: "phone",
                    "last-name": lastname,
                    "first-name": name,
                    skypeid: e.currentTarget.get("title"),
                    "user-id": e.currentTarget.getAttribute("user")
                });
                me.get('container').one('.group-save-btn').removeClass('disabled');
                Y.one('#' + me.pns + 'group-name').removeClass('hidden');
            }, ".icon-phone");
        },

        /**
         *   Adds listener which removes element from the list when the handler is clicked
         */
        setHandlerListener: function () {
            var instance = this;
            Y.one("#"+this.pns+"users").delegate('click', function () {
                this.ancestor('li').remove();
                var users = instance.getUsers();
                if (users.length > 0) {
                    instance.get('container').one('.group-save-btn').removeClass('disabled');
                } else {
                    instance.get('container').one('.group-save-btn').addClass('disabled');
                }
            }, '.handle');
        },

        sortNameListener: function () {
            var me = this;
            Y.one('#' + this.pns + 'users-table').delegate("click", function (e) {
                me.isOrderedName = true;
                me.isOrderedLastName = false;
                me.orderByName();
            }, '#' + this.pns + 'name');
        },

        sortLastNameListener: function () {
            var me = this;
            Y.one('#' + this.pns + 'users-table').delegate("click", function (e) {
                me.isOrderedLastName = true;
                me.isOrderedName = false;
                me.orderByLastName();
            }, '#' + this.pns + 'lastname');
        },

        /**
         *   Opens Skype and loads the usernames/phone numbers if any has been added.
         *
         */
        openSkypeListener: function () {
        	var me = this;
            var skypeBtn = Y.one('#' + this.pns + 'skype-open');
            var skypeClientFrameId = this.skypeHelper.generateDetectionFrame(skypeBtn.get('id'));
            skypeBtn.on("click", function () {
                var users = "",
                    items = Y.all('#' + me.pns + 'users li');

                if (items.size() != 0) {
                    Skype.tryAnalyzeSkypeUri('chat', '0');
                    Y.all('#' + me.pns + 'users li').each(function (li) {
                        users += li.getAttribute("skypeid") + ";";
                    });
                    me.skypeHelper.openSkypeURI(skypeClientFrameId, "skype:" + users + "?chat&topic=" + encodeURIComponent(Y.one('#' + me.pns + 'group-name span').get("text")));

                } else {
                    Y.all(".skype-portlet .portlet-msg-error").setStyle("display", "block");
                }
            });
        },

        /**
         *   Opens Skype and loads the usernames/phone numbers if any has been added.
         *
         */
        callSkypeListener: function () {
        	var me = this;
            var skypeBtn = Y.one('#' + this.pns + 'skype-call');
            var skypeClientFrameId = this.skypeHelper.generateDetectionFrame(skypeBtn.get('id'));
            skypeBtn.on("click", function () {
                var users = "",
                    items = Y.all('#' + me.pns + 'users li');

                if (items.size() != 0) {
                    Skype.tryAnalyzeSkypeUri('chat', '0');
                    Y.all('#' + me.pns + 'users li').each(function (li) {
                        users += li.getAttribute("skypeid") + ";";
                    });
                    me.skypeHelper.openSkypeURI(skypeClientFrameId, "skype:" + users + "?call");
                } else {
                    Y.all(".skype-portlet .portlet-msg-error").setStyle("display", "block");
                }
            });
        },
        
        
        /* Skype helper: generates detection iframe and opens skype */
        skypeHelper: {
            /* Generates detection iframe */
            generateDetectionFrame: function(buttonId) {
                Skype.createDetectionFrame(document.getElementById(buttonId));
                return Skype.detectSkypeClientFrameId;
            },
            /* Opens skype with the given uri */
            openSkypeURI: function(skypeClientFrameId, uri) {
                if (Skype.isChrome && Skype.httpProtocol == 'https:') {
                    window.location = uri;
                    return;
                }
                if (Skype.isIE10 || Skype.isIE9 || Skype.isIE8) {
                    Skype.trySkypeUri_IE9_IE8(uri, '', '');
                } else if ((Skype.isIOS6 || Skype.isIOS5 || Skype.isIOS4) && Skype.isSafari) {
                    Skype.trySkypeUri_IOS_Safari(uri, skypeClientFrameId, '');
                } else if (this.isAndroid && this.isFF) {
                    Skype.trySkypeUri_Android_Firefox(uri, skypeClientFrameId, '');
                } else {
                    Skype.trySkypeUri_Generic(uri, skypeClientFrameId, '');
                }
            }
        },
        
        newGroupListener: function () {
            var me = this;
            Y.one('#' + this.pns + 'skype-new-group').on("click", function () {
                var groupNameNode = Y.one('#' + me.pns + 'group-name');
                if (!groupNameNode.hasClass('hidden')) {
                    groupNameNode.one('span').set('text', Liferay.Language.get('label.unnamed.group'));
                    groupNameNode.one('span').removeAttribute('group-id');
                    groupNameNode.addClass('hidden');
                    Y.one('#' + me.pns + 'users').get("childNodes").remove();
                }
            });
        },
        
        displayGroupsModificationErrors: function(errors) {
            if (errors == 'not.unique.group') {
                this.showMessage(Liferay.Language.get('error'), Liferay.Language.get('not.unique.group'));
            } else {
                this.showMessage(Liferay.Language.get('error'), Liferay.Language.get('error'));
            }
        },
        
        saveGroupListener: function () {
            var me = this,
                id = Y.one('#' + this.pns + 'group-name span').getAttribute("group-id");
            Y.one('#' + this.pns + 'skype-save').on("click", function () {
                if (me.get('container').one('.group-save-btn').hasClass('disabled')) {
                    return;
                }
                var users = [],
                    groupName = Y.one('#' + me.pns + 'group-name span').get("text");
                users = me.getUsers();
                id = Y.one('#' + me.pns + 'group-name span').getAttribute("group-id");
                if (users.length > 0) {
                    me.get('container').one('.group-save-btn').addClass('disabled');
                    if (id == "") {
                        me.addGroup(groupName, users, function(response) {
                            if (!response.success) {
                                me.displayGroupsModificationErrors(response.errors);
                                me.get('container').one('.group-save-btn').removeClass('disabled');
                            } else {
                                Y.one('#' + me.pns + 'group-name span').setAttribute("group-id", response['skype-group-id']);
                                me.showMessage(Liferay.Language.get('message.group.creation.title'),
                                           Y.Lang.sub(Liferay.Language.get('message.group.creation.message'), {groupName: groupName}));
                            }
                            
                            
                        });
                    } else {
                        me.updateGroup(id, groupName, users, function(response) {
                            if (!response.success) {
                                me.displayGroupsModificationErrors(response.errors);
                            } else {
                                me.showMessage(Liferay.Language.get('message.group.update.title'),
                                           Y.Lang.sub(Liferay.Language.get('message.group.update.message'), {groupName: groupName}));
                            }
                        });
                    }
                    
                } else {
                    me.showMessage(Liferay.Language.get('error'), Liferay.Language.get('error.message.select.one.user.to.save'));
                }
                me.getGroups();
            });

        },

        loadGroupListener: function () {
            var me = this;
            Y.one('#' + this.pns + 'skype-load').on("click", function () {
                if (this.hasClass('active')) {
                    Y.one('#' + me.pns + 'groups-list').setStyle("display", "none");
                } else {
                    Y.one('#' + me.pns + 'groups-list').setStyle("display", "block");
                    Y.one('#' + me.pns + 'group-save').setStyle("display", "none");
                    me.getGroups(null, function(groups) {
                        if (me.groupsPaginator) {
                            me.groupsPaginator.set('total', Math.floor((groups.total + me.get('groupsPerPage') - 1) / me.get('groupsPerPage')));
                            me.groupsPaginator.set('page', 1);
                        }
                    });
                }
                this.toggleClass('active');
            });
        },

        groupInfoListener: function () {
            var me = this;
            Y.one('#' + this.pns + 'groups-list').delegate("click", function (e) {
                me.get('container').one('.group-save-btn').addClass('disabled');
                Y.one('#' + me.pns + 'group-name').removeClass('hidden');
                me.getGroupInfo(e.currentTarget.getAttribute("group-id"),
                // using bind to keep the function context to "me"
                Y.bind(me.updateGroupRender, me));

                Y.one('#' + me.pns + 'groups-list').setStyle("display", "none");
            }, ".icon-folder-open");
        },


        iconEditListener: function () {
            Y.one('#' + this.pns + 'groups-list').delegate("click", function (e) {
                e.currentTarget.ancestor(".group-options").next().setStyle("display", "block");
                var li = e.currentTarget.ancestor("li"),
                    span = li.one("span"),
                    spanText = span.get("text"),
                    input = li.one("input[type=text]");
                li.addClass('editing');
                input.set("value", spanText);
                span.setStyle("display", "none");
            }, '#' + this.pns + 'groups .icon-pencil');
        },

        iconSaveEditGroupListener: function () {
            Y.one('#' + this.pns + 'groups-list').delegate("click", function (e) {
                e.currentTarget.ancestor(".edit-group").setStyle("display", "none");
                var li = e.currentTarget.ancestor("li"),
                    span = li.one("span"),
                    input = li.one("input[type=text]");
                li.removeClass('editing');
                input.set("value", "");
                span.setStyle("display", "block");
            }, '#' + this.pns + 'groups .cancel-edit-group');

        },

        searchListener: function() {
            var me = this;
            var placeholder = Liferay.Language.get('skype-search-placeholder');
            var searchForm = this.get('container').one('.users-container .form-search');
            var input = searchForm.one('input[type="text"]');
            var searchTimeout = null;
            
            var execSearch = function() {
                me.currentPage = 1;
                me.searchKeyword = input.get('value');
                me.listUsersCall();
            };
            input.on('keydown', function() {
                searchTimeout = (searchTimeout) ? clearTimeout(searchTimeout) : searchTimeout;
                setTimeout(function() {
                    execSearch();
                }, 1000);
            });
            searchForm.on('submit', function(e) {
                e.halt();
            });
            searchForm.one('button').on('click', function(e) {
                e.preventDefault();
                execSearch();
            });
            /* placeholder in older browsers */
            if (Y.UA.ie == 9) {
                input.set('value', placeholder);
                input.on('focus', function() {
                    input.set('value', (placeholder == input.get('value') ? '' : input.get('value') ));
                });
                input.on('blur', function() {
                    input.set('value', ('' == input.get('value') ? placeholder : input.get('value') ));
                });
            }
        },
        
        iconEditName: function () {
            var me = this;
            var editEvents = function(input) {
                input.focus();
                var execSave = function() {
                    if (input.get('value') != '') {
                        me.iconSaveName();
                    } else {
                        editEvents(input);
                    }
                }
                input.once('blur', function() {
                    execSave();
                });
                input.once('key', function() {
                    execSave();
                }, 'enter');
            };
            Y.one('#' + this.pns + 'group-name').on("click", function (e) {
                var h3 = e.currentTarget,
                    span = h3.one("span"),
                    spanText = span.get("text"),
                    edit = h3.next().setStyle("display", "block");
                input = edit.one('input');

                input.set("value", spanText);
                editEvents(input);
                h3.setStyle("display", "none");
            });
        },

        iconSaveName: function () {
            var me = this;
            var h3 = Y.one('#' + me.pns + 'group-name'),
            span = h3.one("span");

            var edit = h3.next().setStyle("display", "none");
            input = edit.one('input'), id = span.getAttribute("group-id");

            span.set("text", input.val());
            h3.setStyle("display", "block");

            if (id != "") {
                var users = me.getUsers();
                if (users.length > 0) {
                    me.updateGroup(id, input.val(), users);
                } else {
                    me.showMessage(Liferay.Language.get('error'), Liferay.Language.get('error.message.select.one.user.to.save'));
                }
            }

        },

        iconDeleteGroup: function () {
            var me = this;
            Y.one('#' + this.pns + 'groups-list').delegate("click", function (e) {
                var id = e.currentTarget.ancestor('.group-options').one('.icon-folder-open');
                var name = e.currentTarget.ancestor('li').one('.group-label').get('text');
                id = id.getAttribute("group-id");
                if (id != "") {
                    var confirm = window.confirm(Y.Lang.sub(Liferay.Language.get("message.delete.group"), {groupName: name}));
                    if (confirm) {
                        me.removeGroup(id);
                    }
                }
            }, ".icon-remove");
        },

/** -------------------------------- MISCELLANEOUS ---------------------------------/*

        /**
        *   Checks whether a user is already in the list of users to call
        *
        */
        isInList: function (personId) {
            var users = "";
            Y.all("#"+this.pns+" .skype-users-to-call li").each(function (li) {
                users += li.getAttribute("skypeid") + ";";
            });
            return users.indexOf(personId) == -1;
        },
        getUsers: function () {
            var users = [],
                userid, isSkype, cssClass;
            Y.all('#' + this.pns + 'users li').each(function (element) {
                userid = element.getAttribute("user");
                cssClass = element.getAttribute("class");

                isSkype = (cssClass.indexOf("skype") != -1);
                users.push({
                    'user-id': userid,
                    'is-skype': isSkype
                });

            });
            return users;
        },

        showMessage: function (title, message) {
            new Y.Modal({
                bodyContent: '<p>' + message + '</p>',
                centered: true,
                headerContent: '<h2>' + title + '</h2>',
                render: '#' + this.pns + 'modal',
                height: 250,
                modal: true
            }).render();
        },

        /**
         * List
         *
         */
        initializer: function () {
        	this.pns = this.get('portletNamespace');	
            this.listUsersCall();
            this.setSkypeListener();
            this.setPhoneListener();
            this.sortNameListener();
            this.sortLastNameListener();
            this.setHandlerListener();
            this.openSkypeListener();
            this.callSkypeListener();
            this.saveGroupListener();
            this.newGroupListener();
            this.searchListener();
            this.loadGroupListener();
            this.groupInfoListener();

            this.iconEditListener();
            this.iconSaveEditGroupListener();
            this.iconDeleteGroup();
            this.iconEditName();
        }
    }, {
        ATTRS: {

            portletNamespace: {
                value: ''
            },

            container: {
                value: null
            },

            resourceUrl: {
                value: ''
            },

            isMobile: {
                value: false
            },

            usersPerPage: {
                value: 10
            },

            groupsPerPage: {
                value: 5
            }

        }
    })
}, '@VERSION@', {
    "requires": ["yui-base", "base-build", "node", "event", 'node', 'event', 'aui-datatable', 'aui-modal', 'aui-tooltip', 'handlebars', 'json-parse', 'io-base', 'aui-io-request', 'rivet-aui-pagination']
});