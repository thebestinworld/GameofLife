(function (angular) {
    angular.module("myApp.gameoflife", []);
    angular.module("myApp", ["ngResource", "myApp.gameoflife"]);
}(angular));