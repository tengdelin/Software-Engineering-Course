#pragma once
template<typename T>
class CMartrix4 {
public:
	CMartrix4();
	~CMartrix4();
    CMartrix4 operator*(const CMartrix4& a);
	CMartrix4& operator=(const CMartrix4& a);
	void SetElements();
	void PrintMartrix();
	void FileInput(CMartrix4& a, CMartrix4& b);
private:
	T Mar[4][4];
};
template<typename T>CMartrix4<T>::CMartrix4() {
	for (int i = 0; i < 4; i++)
		for (int j = 0; j < 4; j++)
			Mar[i][j] = 0;
}
template<typename T>CMartrix4<T>::~CMartrix4(){}
template<typename T>
CMartrix4<T> CMartrix4<T>::operator*(const CMartrix4& a) {
	CMartrix4 temp;
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			for (int k = 0; k < 4; k++)
				temp.Mar[i][j] += Mar[i][k] * a.Mar[k][j];
		}
	}
	return temp;
}
template<typename T>
CMartrix4<T>& CMartrix4<T>:: operator=(const CMartrix4& a) {
	for (int i = 0; i < 4; i++)
		for (int j = 0; j < 4; j++)
			(*this).Mar[i][j] = a.Mar[i][j];
	return *this;
}
template<typename T>void CMartrix4<T>::SetElements() {
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			cin >> Mar[i][j];
		}
	}
}
template<typename T>void CMartrix4<T>::PrintMartrix() {
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			cout << Mar[i][j] << " ";
		}
		cout << endl;
	}
}
template<typename T>void CMartrix4<T>::FileInput(CMartrix4& a, CMartrix4& b) {
	ifstream in("1.txt");
	for (int i = 0; i < 4; i++)
		for (int j = 0; j < 4; j++)
			in >> a.Mar[i][j];
	in.close();
   ifstream in2("2.txt");
	for (int i = 0; i < 4; i++)
		for (int j = 0; j < 4; j++)
			in2 >> b.Mar[i][j];
	in2.close();
}