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

        var value = $(this).find('input[name="value"]').val();
        var countryCode = $(this).find('input[name="countryCode"]').val();

        $.ajax({
            url: '/salary-calculator/salary/pln/?countryCode=' + countryCode + '&salary=' + value,
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