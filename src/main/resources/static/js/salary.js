/**
 * Created by MikBac on 2018
 */
APP.salary = {

    _autoload: [
        'bindCalculateSalary'
    ],

    bindCalculateSalary: function () {
        var form = 'form.js-calculate-form';

        $(form).submit(APP.salary.getSalary)
    },

    getSalary: function (event) {
        event.preventDefault();

        var value = $(this).find('input[name="value"]').val().replace(',', '.');
        var countryCode = $(this).find('input[name="countryCode"]').val();

        $.ajax({
            url: '/api/salaries/pln/?countryCode=' + countryCode + '&salary=' + value,
            type: 'GET',
            success: function (response) {
                console.log(response)
                $('.js-resoult' + countryCode).text(response);
            },
            error: function () {
                console.error('error');
            }
        })
    }

};