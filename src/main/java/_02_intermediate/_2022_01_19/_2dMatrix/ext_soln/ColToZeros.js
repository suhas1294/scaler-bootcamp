// credits : https://leetcode.com/problems/set-matrix-zeroes/discuss/1698334/Javascript-Time-O(nm)-Space-O(1)-With-Comments
/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 *
 * Time Complexity = O(2(n * m) + n + m) = O(2nm + n + m) = O(2nm) = O(nm)
 * Space Complexity = O(1)
 */
var setZeroes = function(matrix) {

    // Initialize flag that tells us whether or not
    // the first column contains 0
    let firstCol = false;

    // Initialize number of rows m and number of
    // columns n because they get re-used several
    // times
    let m = matrix.length;
    let n = matrix[0].length;

    // First iteration through all positions
    //      1. If any cell in the first column contains 0
    //         then set flag firstCol to true
    //      2. If any cell contains 0, set the first cell
    //         of its row and column to 0 as a marker
    for (let i = 0; i < m; i++) {
        if (!matrix[i][0]) firstCol = true;
        for (let j = 0; j < n; j++) {
            if (!matrix[i][j]) {
                matrix[0][j] = 0;
                matrix[i][0] = 0;
            }
        }
    }

    // Second iteration through all positions
    //      Start at row 1 and column 1 because the
    //      first row and column need special attention
    //      Set a cell to 0 if the beginning of its row
    //      or column is 0
    // O(nm)
    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) {
            if (!matrix[i][0] || !matrix[0][j]) {
                matrix[i][j] = 0;
            }
        }
    }

    // Set first row to 0 if first element is 0
    //      Now every cell that needs to be 0 is set,
    //      except for those in the first column or
    //      first row
    //      If the starting position contains 0, set
    //      the entire first row to 0
    // O(n)
    if (matrix[0][0]) {
        for (let i = 0; i < n; i++) matrix[0][i] = 0;
    }

    // Set first column to 0 if our flag is set
    //      The only cells we haven't set to 0 (if needed)
    //      are the cells in the first column. This is why
    //      we set our flag in the beginning. We needed to
    //      reserve the first row and column for our markers
    //      Now if our flag is true, we can finally set the
    //      first column to 0
    // O(m)
    if (firstCol) {
        for (let i = 0; i < m; i++) matrix[i][0] = 0;
    }

    return matrix;
};