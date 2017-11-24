$(document).ready(function () {
    navApp = new Vue({
        el: '#nav_view',
        data: {
            allItems:[],
            titleMessage:"List of all Items",
            totalAmount:0
        },
        methods: {
            getAllItems: function () {
                var vm = this;
                $.get("/supermarket/items", function (data) {
                    console.log("success retrieved getAllItems = " + data);
                    for(i=0;i<data.length;i++)
                    	data[i].quantity=0;
                    vm.allItems = data;
                }).fail(function () {
                    console.log("error");
                });
            }, 
            calculatePrice: function(item){
            	console.log("checkout clicked ...." + item);
            	var vm = this;
            	var req = "/supermarket/calcPrice?qnty="+item.quantity+"&id="+item.id
                $.get(req, function (data) {
                    console.log("success retrieved getAllItems = " + data);
                    vm.totalAmount += data;
                }).fail(function () {
                    console.log("error");
                });
                
            }
        }, 
        created: function () {
        	console.log("log to created method ....");
            this.getAllItems();
        }
      })
})


