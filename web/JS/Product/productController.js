angular.module('Van.controllers').
	controller('productController', function ($scope, $rootScope, productService) {
		var vm = this;
                vm.products = [];
			
                $rootScope.$emit('Van.OnBusy');

                productService.getProducts().then(
                                function success(data)
                                {
                                        vm.products = data;
                                        $rootScope.$emit('Van.OnSuccessPay', 'Got products ');
                                        $rootScope.$emit('Van.OnIdle');
                                }
                                ,
                                function error(data)
                                {
                                        $rootScope.$emit('Van.OnError', 'Error in getting products');
                                        $rootScope.$emit('Van.OnIdle');
                                }
                        );
		

	});