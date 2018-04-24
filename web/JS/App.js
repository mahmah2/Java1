angular.module('Van.controllers', []);
angular.module('Van.services', []);

var VanApp = angular.module("VanApp", [
	"ngMaterial",
	"ui.router",
	"ngMessages",
	"Van.controllers",
	"Van.services"
]);

VanApp.config(function ($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise("/");

	$stateProvider.state('/', {
		templateUrl: 'JS/Home/home.html',
		url: '/'
	})
	
	
	var productState = {
		name: 'product',
		url: '/product',
		templateUrl: 'JS/Product/productList.html'
	}

	$stateProvider.state(productState);
});


VanApp.controller('MainController', ['$scope', '$rootScope', '$state', '$mdToast',
		function ($scope, $rootScope, $state, $mdToast) {

                    var vm = this;
                    //Global variables
                    $rootScope.ServerURL = 'http://localhost:8084/VanApp';
                    vm.AppName = 'VanApp';
                    vm.Busy = false;
                
                    $rootScope.$on('Van.OnBusy', function (ev) {
                        vm.Busy = true;
                    });		

                    $rootScope.$on('Van.OnIdle', function (ev) {
                        vm.Busy = false;
                    });
}]);
