'use strict';

// configuring our routes
// =============================================================================
loanApp.config(function($stateProvider, $urlRouterProvider) {
    //
    // For any unmatched url, redirect to /state1
    $urlRouterProvider.otherwise("/home");
    //
    // Now set up the states
    $stateProvider
        .state('home', {
            url: "/home",
            templateUrl: "partials/home.html"
        })
        .state('loan', {
            abstract: true,
            url: "/loan",
            templateUrl: "partials/loan/form-loan.html"
        })
        .state('loan.credit-check', {
            url: "/credit-check",
            templateUrl: "partials/loan/form-credit-check.html"
        })
        .state('loan.completed', {
            url: "/completed",
            templateUrl: "partials/loan/form-completed.html"
        });
});