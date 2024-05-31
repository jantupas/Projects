import sys
import os
class Page:
    def __init__(self, pageNum, freq):
        self.pageNum = pageNum
        self.freq = freq


def check_freq(lst):
    first_element = lst[0]
    return all(element == first_element for element in lst)


def has_duplicate(lst):
    unique_values = set()
    for element in lst:
        if element in unique_values:
            return True
        unique_values.add(element)
    return False

def main():
    while True:
        with open('MP06 Checker.txt') as f:
            lines = f.readlines()
            stringSize = int(lines[0].strip())
            refString = lines[1].strip().split()
            refStringFinal = [int(num) for num in refString]
            pageSize = int(lines[2].strip())
            # print(stringSize)
            # print(refString)
            # print(pageSize)
            history = []
            final = []
            pageList = []
            freqList = []
            checkList = []
            checkListNum = []
            final_num = []
            page_fault = 0
            final_array = []

            for num in refStringFinal:
                pages = Page(num, 0)
                pageList.append(pages)

            for page in pageList:
                if len(final) < pageSize:
                    history.append(page)
                    final.append(page)
                    page.freq += 1
                    final_num = [f.pageNum for f in final]
                elif len(final) == pageSize:
                    for f in final:
                        checkList.append(f.freq)
                        checkListNum.append(f.pageNum)
                    if page.pageNum in checkListNum:
                        p_index = checkListNum.index(page.pageNum)
                        final[p_index].freq += 1
                        final_num.clear()
                    elif check_freq(checkList):
                        rep = history[0]
                        history.pop(0)
                        rep_index = final.index(rep)
                        final[rep_index].freq = 0
                        final[rep_index] = page
                        page.freq += 1
                        history.append(page)
                        final_num = [f.pageNum for f in final]
                    else:
                        minimum = min(history, key=lambda x: x.freq)
                        min_index = checkListNum.index(minimum.pageNum)
                        history.remove(minimum)
                        final[min_index].freq = 0
                        final[min_index] = page
                        page.freq += 1
                        history.append(page)
                        final_num = [f.pageNum for f in final]

                checkList.clear()
                checkListNum.clear()
                if final_num:
                    page_fault += 1
                while len(final_num) < pageSize:
                    final_num.append(None)
                #print(final_num)
                final_array.append(list(final_num))


        name = "Jan Edgar E. Tupas"

        combined = ' '.join(refString)

        print("Programmed by: {}".format(name))
        print("MP06 - LFU PAGE REPLACEMENT")
        print("enter reference string size: {}".format(stringSize))
        print("enter reference string: {}".format(combined))
        print("Frame Size: {}".format(pageSize))
        print("")
        print("Page Replacement Table")
        #print(final_array)


        for page_num in refStringFinal:
            print(f"{page_num:2d}", end=" " * 3)

        print("\n" + "=====" * (1 * len(refStringFinal)))

        columns = [[] for _ in range(len(final_array[0]))]

        for row in final_array:
            for i, element in enumerate(row):
                if element is not None:
                    columns[i].append(f"[{element}]")
                else:
                    columns[i].append("[ ]")

        # Print the columns horizontally
        for column in columns:
            print("  ".join(column))

        print("")
        print("Display Page Fault: {}".format(page_fault))
        print("")

        file_path = "MP06 Checker.txt"
        with open(file_path, "a") as file:

            sys.stdout = file
            name = "Jan Edgar E. Tupas"

            combined = ' '.join(refString)

            print("")
            print("Programmed by: {}".format(name))
            print("MP06 - LFU PAGE REPLACEMENT")
            print("enter reference string size: {}".format(stringSize))
            print("enter reference string: {}".format(combined))
            print("Frame Size: {}".format(pageSize))
            print("")
            print("Page Replacement Table")

            # print(final_array)

            for page_num in refStringFinal:
                print(f"{page_num:2d}", end=" " * 3)

            print("\n" + "=====" * (1 * len(refStringFinal)))

            columns = [[] for _ in range(len(final_array[0]))]

            for row in final_array:
                for i, element in enumerate(row):
                    if element is not None:
                        columns[i].append(f"[{element}]")
                    else:
                        columns[i].append("[ ]")

            # Print the columns horizontally
            for column in columns:
                print("  ".join(column))

            print("")
            print("Display Page Fault: {}".format(page_fault))
            print("")

        sys.stdout = sys.__stdout__
        while True:
            run_again = input("Do you want to run again [y/n]: ").strip().lower()
            if run_again == 'n' or run_again == 'y':
                break
            else:
                print("Invalid input. Please enter 'y' or 'n'.")

        if run_again == 'n':
            break
        else:
            os.system('cls')

if __name__ == "__main__":
    main()





