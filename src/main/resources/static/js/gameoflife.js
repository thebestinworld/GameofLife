(function (angular) {
    var AppController = function ($scope, $http) {

        $scope.newGame = function () {
            $scope.board = init($scope.height, $scope.width);
            $scope.generation = 0;
            $scope.autoplay(false);
        };


        $scope.next = function () {
            $http({
                method: 'PUT',
                url: 'nextGeneration',
                data: {
                    board: $scope.board
                }
            }).then(function successCallback(response) {
                $scope.board = response.data.board;
                $scope.generation = response.data.generation;

            });
        };



        $scope.random = function () {
            $http({
                method: 'PUT',
                url: 'randomBoard',
                data: {
                    board: $scope.board
                }
            }).then(function successCallback(response) {
                $scope.board = response.data.board;
                $scope.generation = response.data.generation;

            });
        };

        $scope.toggle = function (row, cell) {
            $scope.board[row][cell] = !$scope.board[row][cell];
        };



        $scope.autoplay = function (check) {
            if (check) {
                $scope.autoplayInterval = setInterval(function () {
                    $scope.next();
                }, 150);
            } else {
                clearInterval($scope.autoplayInterval);
            }
        };

        $scope.generation = 0;
        $scope.height = 25;
        $scope.width = 30;
        $scope.newGame();

        function init(height, width) {
            var board = [];
            for (var h = 0; h < height; h++) {
                var row = [];
                for (var w = 0; w < width; w++) {
                    row.push(false);
                }
                board.push(row);
            }
            return board;
        }


    };



    angular.module("myApp.gameoflife").controller("AppController", AppController);
}(angular));