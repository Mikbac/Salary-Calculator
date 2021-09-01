/**
 *  Created by MikBac on 1.09.2021
 */

APP.autoload = {

    _autoloadObjects: [
        "salary"
    ],

    load: function () {
        APP.autoload._autoloadObjects.forEach(function (elementsPackage) {
            APP[elementsPackage]._autoload.forEach(function (element) {
                APP[elementsPackage][element]();
            })
        })

    },

}

window.addEventListener('load', APP.autoload.load);
