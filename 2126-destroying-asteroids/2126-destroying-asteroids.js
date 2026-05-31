/**
 * @param {number} mass
 * @param {number[]} asteroids
 * @return {boolean}
 */
var asteroidsDestroyed = function(mass, asteroids) {
    asteroids.sort((a, b) => Number(a) - Number(b));
    for(let a of asteroids) {
        if(mass < a) return false;
        mass = mass + a;
    }
    return true;
};