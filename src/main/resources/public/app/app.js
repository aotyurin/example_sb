(function () {
    'use strict';

    define(["Vue", "vue!App"],
        function (Vue) {
            require(["vue!App"],
                function () {
                    new Vue({
                        el: '#app',
                        template: '<App/>'
                    });
                }
            );
        }
    );
})();