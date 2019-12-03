<template>
    <div>{{text}}</div>
</template>
<script>
    define(["Vue", "a", "b", "c"],
        function (Vue, a,b,c) {
            return Vue.component("App", {
                template: template,
                data: function () {
                    return {
                        text: "Hello Vue component!"
                    }
                }
            });
        }
    );
</script>