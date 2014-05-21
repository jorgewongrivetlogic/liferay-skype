AUI.add('rivet-aui-pagination', function (Y, NAME) {

    Y.namespace('Rivet');
    /* module templates */
    var FIRST_NAV_LINK_TPL = '<li class="first-pagination-control"><a href="#">{text}</a>';
    var LAST_NAV_LINK_TPL = '<li class="last-pagination-control"><a href="#">{text}</a>';

    Y.Rivet.Pagination = Y.Base.create('rivet-aui-pagination', Y.Pagination, [], {

        initializer: function () {
            var instance = this;

            this.on('changeRequest', function (event) {
                var paginationItems = this.get('boundingBox').all('li a');
                var range = instance.calculateRange(event.state.page, instance.get('maxPagesNavItems'), this.get("total"));
                paginationItems.removeClass('hidden');
                paginationItems.each(function (node) {
                    if (Y.Lang.isNumber(parseInt(node.get('text')))) {
                        var itemNumber = parseInt(node.get('text'));
                        if (itemNumber < range.start || itemNumber > range.end) {
                            node.addClass('hidden');
                        }
                    };
                });
            });

            this.on('itemsChange', function () {
                window.setTimeout(Y.bind(instance.renderButtons, this), 500);
            });
            this.bindButtons();
        },

        renderButtons: function () {
            this.get('boundingBox').all('ul').prepend(Y.Lang.sub(FIRST_NAV_LINK_TPL, {
                text: this.get('firstNavLinkText')
            }));
            this.get('boundingBox').all('ul').append(Y.Lang.sub(LAST_NAV_LINK_TPL, {
                text: this.get('lastNavLinkText')
            }));
        },

        bindButtons: function () {
            var instance = this;
            this.get('boundingBox').delegate('click', function (e) {
                e.halt(true);
                instance._dispatchRequest({
                    page: 1
                });
            }, '.first-pagination-control a');

            this.get('boundingBox').delegate('click', function (e) {
                e.halt(true);
                instance._dispatchRequest({
                    page: instance.get('total')
                });
            }, '.last-pagination-control a');
        },

        /**
         * Create a range to display on the pageLinks, keep the current page on
         * center.
         *
         * @method calculateRange
         * @param {Number} Current selected page
         * @param {Number} Max of the pages to show
         * @param {Number} Total pages
         * @return {Object} Object containing the start and end information.
         */
        calculateRange: function (page, maxPageLinks, totalPages) {
            var instance = this;

            var offset = Math.ceil(maxPageLinks / 2);

            // this fixes when the offset is small and generates less than [maxPageLinks] page links
            var start = Math.min(
            // Math.max(x, 1) doesn't allow negative or zero values
            Math.max(page - offset, 1), (totalPages - maxPageLinks + 1));

            // (start + maxPageLinks - 1) try to find the end range
            // Math.min with totalPages doesn't allow values bigger than totalPages
            var end = Math.min(start + maxPageLinks - 1, totalPages);

            return {
                end: end,
                start: start
            };
        }

    }, {
        ATTRS: {

            /**
             * 
             * Number of pages nav links to be displayed
             * 
             */
            maxPagesNavItems: {
                value: 10
            },

            firstNavLinkText: {
                value: 'First'
            },

            lastNavLinkText: {
                value: 'Last'
            }
        }
    });

}, '1.0', {
    "requires": ["yui-base", "base-build", "aui-pagination"]
});