angular.module('Van.services')
	.service('productService', ['$http', '$rootScope', '$q',
    function ($http, $rootScope, $q) {

        var self = this;

        self.getProducts = function () {
            var deferred = $q.defer();

            console.log('getting product list');

            $http.get($rootScope.ServerURL + "/ProductServlet")
                .then(
                    function (response) {
                        if (response.status == 200 ) //&& response.data)
                        {
                            deferred.resolve(response.data);
                        }
                        else
                        {
                            deferred.reject("(getProduct): Error in communication with server." + response.statusText);
                        }

                    }, 
                    function (response) {
                        return deferred.reject(response.statusText);
                    }
                );

            return deferred.promise;
        }

            
        self.savePayment = function (paymentInfo) {
			
            var deferred = $q.defer();

            console.log(paymentInfo);

            console.log(JSON.stringify(paymentInfo));

							
            $http.post($rootScope.ServerURL + "/ProductServlet"
            //, JSON.stringify({Email: userName,})
            , JSON.stringify(paymentInfo)
            , { headers: { 'Content-Type': 'application/json' } }
                    )
                    .then(
                    function (response) {
                        if (response.status == 200 ) //&& response.data)
                {
                    deferred.resolve(paymentInfo);
                }
                else
                {
                    deferred.reject("(savePayment): Error in communication with server." + response.statusText);
                }

            }, 
            function (response) {
                return deferred.reject(response.statusText);
            }
                    );

            return deferred.promise;



        }

	




    }]
	);
