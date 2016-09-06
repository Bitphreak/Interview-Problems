
import random

def merge_sort(items):
    sorted_items = list(items)

    partition_size = 1

    while partition_size < len(sorted_items) :
        
        partition = 0;
        while partition < len(sorted_items) / partition_size :
            merge_partitions(sorted_items, partition, partition_size)
            partition += 2

        partition_size = partition_size * 2

    return sorted_items

def merge_partitions(items, start_partition, partition_size) :
    i = start_partition * partition_size
    j = (start_partition + 1) * partition_size

    ai = items[i:i+partition_size]
    aj = items[j:j+partition_size]

    merged_items = []
    ei = 0;
    ej = 0;
    for e in xrange(len(ai) + len(aj)) :
        if ei >= len(ai) :
            merged_items.extend(aj[ej:])
            break
        elif ej >= len(aj) :
            merged_items.extend(ai[ei:])
            break
        
        if ai[ei] <= aj[ej] :
            merged_items.append(ai[ei])
            ei += 1
        else :
            merged_items.append(aj[ej])
            ej += 1

    items[i:j + len(aj)] = merged_items 


if __name__ == '__main__':
    items = [int(100*random.random()) for i in xrange(int(20*random.random()))]
    print items

    print merge_sort(items)
