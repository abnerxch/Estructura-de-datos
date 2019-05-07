/**
 * quick sort animated algorithm
 */
function* algorithm() {

    // n is the number of items to sort
    var n = 30;

    // create a simple grid layout for positoning the bars
    var layout = new algo.layout.GridLayout(algo.BOUNDS.inflate(-2, -2), 1, n);

    // scale height of bars by available height
    var H = layout.getBox(0, 0).h / (n + 1);

    // create an array containing n values from 1 to H and then shuffle it to create the initial un-sorted data set
    var data = algo.core.createMultiArray(n);
    for (var i = 1; i <= n; i += 1) {
        data[i - 1] = i * H;
    }

    //=shuffle array, otherwise its already sorted
    data = algo.core.shuffleArray(data);

    // create an array visualizer to display the array
    var visualizer = new algo.core.Array({

        // seed with shuffled array
        data: data,

        // create rectangles for each element
        createElement: _.bind(function(value, index) {

                // get layout cell for this element
                var box = layout.getBox(0, index).inflate(-2, 0);

                // create a new rectangle positioned at the bottom of the layout cell and centered horizontally
                var rect = new algo.render.Rectangle({

                    x: box.x,
                    y: box.b - value,
                    w: box.w,
                    h: value,
                    fill: algo.Color.iGRAY,
                    strokeWidth: 0,
                    z: 0

                });

                // define some display states for the boxes
                rect.set({
                    states: [{
                        name: 'ACTIVE',
                        properties: {
                            fill: algo.Color.iBLUE,
                            z: 0,
                        }
                    }, {
                        name: 'INACTIVE',
                        properties: {
                            fill: algo.Color.iGRAY,
                            z: 0,
                        }
                    }, {
                        name: 'SWAPPING',
                        properties: {
                            fill: algo.Color.iORANGE,
                            z: 1000
                        }
                    }, {
                        name: 'PIVOT',
                        properties: {
                            fill: algo.Color.iRED,
                            z: 1000
                        }
                    }]
                });

                return rect;

            },
            this),

        // when two items are swapped in the array visualizer update their x position
        swapElement: _.bind(function(value, newIndex, oldIndex, element) {

            element.set({
                x: layout.getBox(0, newIndex).inflate(-2, 0).x
            });
        })
    });

    // create a simple wrapper around accesses to the visualizers values / elements to make the code more readable

    var a = visualizer.getValueAccessor();
    var e = visualizer.getElementAccessor();


    // this is the partition method of the quick sort algorithm. It is defined as a generator so that
    // it may be called from another generator and yield
    //=partition
    function* partition(left, right) {

        var i, j, v;

        // set the appearance of all elements, those outside the partition are grayed,
        // those with it are highlighted and the partition element itself is shown in red

        for (i = 0; i < n; i += 1) {
            e(i).set({
                state: i >= left && i <= right ? (i === right ? 'PIVOT' : 'ACTIVE') : 'INACTIVE'
            });
        }

        // -------------------------------------------------------------------------------------------------------------

        yield ({
            step: 'Partition procedure from ' + left + ' to ' + right +
                'In this step a sub-section of the array is divided around a pivot value. In this version of quicksort ' +
                'the pivot value is always the right most value in the sub-section to be partitioned. Starting from the left ' +
                'and right ends of the sub section we work towards to center, exchanging elements from the left that are higher ' +
                'that the pivot value with elements from the right which are lower than the pivot value.',
            line: "partition"
        });

        // ###

        // use i and j to walk toward through the section swapping items as necessary.
        // NOTE: i is pre-incremented and j is pre-decremented inside the inner loop
        // so there initialized values and outside the range to be divided. Since we don't want to
        // divide the pivot value itself j is initialized to right so that right-1 is the first value
        // considered for swapping

        i = left - 1; // i index is left edge of subsection of array we are partitioning
        j = right; // j is the end of subsection, pre-decrement so it skips the partition index
        v = a(right); // v is the value we are going to partition around

        // -------------------------------------------------------------------------------------------------------------

        // repeat until i and j meet, which could be anywhere between i -> j

        while (true) {

            // set i to point to a value >= the pivot

            while (a(++i) < v);

            // set j to point to a value less than the pivot being careful to abort if i and j meet.

            while (v < a(--j)) {

                if (i >= j) break;
            }

            // if i and j didn't meet then we need to swap the values at i and j
            //=compare
            if (i >= j) {
                //=stop
                break;
            }

            // highlight the swapping elements
            algo.render.Element.set({
                state: 'SWAPPING'
            }, e(i), e(j));

            // ---------------------------------------------------------------------------------------------------------

            yield ({
                step: 'The highlighted elements will be swapped. The left element is higher than the pivot value ' +
                    'the right element is lower than the pivot value',
                line: 'compare'
            });

            // swap the items
            //=swap
            visualizer.swap(i, j);

            // ---------------------------------------------------------------------------------------------------------

            yield ({
                step: 'The elements position have swapped positions in the array.',
                variables: {
                    i: i,
                    j: j
                },
                lineNumber: 'swap'
            });

            // restore normal color on swapped elements
            algo.render.Element.set({
                state: 'ACTIVE'
            }, e(i), e(j));

        }

        // highlight where the pivot value will be moved to

        e(i).set({
            state: 'SWAPPING'
        });

        // -------------------------------------------------------------------------------------------------------------

        yield ({
            step: 'The exchanging of elements stops when the left and right indices meet at the same position. ' +
                'The meeting position indicates the correct place to move the pivot value to from its original ' +
                'location at the right end of the partition.',
            variables: {
                i: i,
                right: right
            },
            lineNumber: "stop"
        });

        // finally, i point to the correct location to insert the pivot at. The current value at i belongs in the
        // right half of the array so the swap ensures the array is now partitioned around index i

        visualizer.swap(i, right);
        algo.render.Element.set({
            state: 'ACTIVE'
        }, e(i), e(right));

        yield ({
            step: 'The partition process is now complete. The pivot is in its correct position is the partition',
            variables: {
                i: i,
                right: right
            },
            line: 'returnPivot'
        });

        // return the pivot location so that we can make recursive calls to refine the sorting in each remaining half of the array

        //=returnPivot
        return i;
    };

    // -----------------------------------------------------------------------------------------------------------------

    yield ({
        step: "Create an array to sort with" + n + " random values between 1 and " + n,
        line: "shuffle"
    });

    // start with a partition of the full array

    var stack = [{
        left: 0,
        right: n - 1
    }];

    // while there are partitions to work with

    while (stack.length) {

        var t = stack.pop();

        // stop if the partition is too small to partition [ 0 or 1 elements ]

        if (t.left < t.right) {

            var pivot =
                yield * partition(t.left, t.right);
            stack.push({
                left: t.left,
                right: pivot - 1
            });
            stack.push({
                left: pivot + 1,
                right: t.right
            });
        }
    }

    // show all elements as gray
    algo.ROOT.children.set({
        state: 'INACTIVE'
    });

    //=done
    yield ({
        step: "The sort is completed when all partitions have been sorted.",
        line: "done"
    });
}