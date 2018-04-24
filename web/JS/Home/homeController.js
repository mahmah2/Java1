angular.module('Van.controllers').
	controller('homeController', ['$scope', '$rootScope', '$state', '$mdToast',
		function ($scope, $rootScope, $state, $mdToast) {

                    var vm = this;

                    $rootScope.$on('Van.OnSuccess', function (ev, msg) {
                            $mdToast.show($mdToast.simple().textContent(msg).theme("success-toast"));
                    });	

                     $rootScope.$on('Van.OnError', function (ev, msg) {
                            $mdToast.show($mdToast.simple().textContent(msg).theme("error-toast"));
                    });	    

	}]);

