package nextfitmemoryallocation;

import java.util.List;

public class NextFitAllocator {
    /**
     * Allocates processes to memory blocks using the Next Fit algorithm.
     *
     * @param memoryBlocks  an array representing the size of each memory block
     * @param processSizes  an array representing the size of each process
     * @return              a string representation of the allocation results
     */
    public String allocate(int[] memoryBlocks, int[] processSizes) {
        StringBuilder result = new StringBuilder();
        int[] allocation = new int[processSizes.length];
        int lastAllocatedIndex = 0;

        // Initialize allocations to -1
        for (int i = 0; i < allocation.length; i++) {
            allocation[i] = -1;
        }

        // Perform Next Fit allocation
        for (int i = 0; i < processSizes.length; i++) {
            boolean allocated = false;

            for (int j = 0; j < memoryBlocks.length; j++) {
                int index = (lastAllocatedIndex + j) % memoryBlocks.length;

                if (memoryBlocks[index] >= processSizes[i]) {
                    allocation[i] = index;
                    memoryBlocks[index] -= processSizes[i];
                    lastAllocatedIndex = index;
                    allocated = true;
                    break;
                }
            }

            if (allocated) {
                result.append("Process ").append(i + 1).append(" of size ").append(processSizes[i])
                      .append(" allocated to block ").append(allocation[i] + 1).append("\n");
            } else {
                result.append("Process ").append(i + 1).append(" of size ").append(processSizes[i])
                      .append(" could not be allocated.\n");
            }
        }

        return result.toString();
    }

    /**
     * Overloaded method to allocate using List<Integer>.
     *
     * @param memoryBlocks  a List representing memory block sizes
     * @param processSizes  a List representing process sizes
     * @return              a string representation of the allocation results
     */
    public String allocate(List<Integer> memoryBlocks, List<Integer> processSizes) {
        int[] memoryArray = memoryBlocks.stream().mapToInt(Integer::intValue).toArray();
        int[] processArray = processSizes.stream().mapToInt(Integer::intValue).toArray();
        return allocate(memoryArray, processArray);
    }
}
