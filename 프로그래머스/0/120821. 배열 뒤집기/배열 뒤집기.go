func solution(num_list []int) []int {
    
    arraySize := len(num_list)
    middleIndex := arraySize/2
    
    
    for i := 0; i < middleIndex; i++ {
        temp := num_list[i]
        num_list[i] = num_list[(arraySize-1) - i]
        num_list[(arraySize-1) - i] = temp
    }
    
    return num_list
}