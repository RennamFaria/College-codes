Weight = float(input("What is your weight?: "))
Type = input("It is in Kg or Lbs?: ")

if Type.upper() == "KG":
    print("Weight in Lbs: {:.4}" .format(Weight * 2.204))

if Type.upper() == "LBS":
    print("Weight in Kg: {:.4}" .format(Weight / 2.204))

else:
    print("Youy tipe the wrong word.")