'use strict';

// Controllers
// =============================================================================

loanApp.controller('NavCtrl', function($scope, $location) {
    $scope.isActive = function(route) {
        var matches = $location.path().match(route);
        return matches !== null && matches.length === 1;
    };
});

loanApp.controller('CreditCheckCtrl', ['$scope', '$http', function($scope, $http) {
    $scope.model = {};

    $scope.submitForm = function(loan) {
        // remove success messages
        $('#messages').removeClass('alert alert-success alert-alert-danger').empty();

        // get the form data
        var formData = loan;
        console.log(formData);
        console.log(JSON.stringify(formData));

        // process the form
        $http({
            method 		: 'POST',
            url 		: 'http://localhost:63342/creditCheck',
            data 		: JSON.stringify(formData),

            success 	: function(data) {

                // log data to the console so we can see
                console.log(data);

                // if validation fails
                if ( ! data.success) {
                    $('#messages').addClass('alert alert-alert-danger').append('<p>' + data.message + '</p>');

                } else {

                    // if validation is good add success message
                    $('#messages').addClass('alert alert-success').append('<p>' + data.message + '</p>');
                }
            }
        });

        // stop the form from submitting and refreshing
        event.preventDefault();
    };
}]);