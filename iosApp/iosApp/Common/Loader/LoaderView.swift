//
//  LoaderView.swift
//  iosApp
//
//  Created by Vika on 18.08.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

fileprivate extension Appearance {
	var loadingText: String { "Loading..." }
	var spacerHeight: CGFloat { 15 }
}

struct LoaderView: View {
	private let appearance: Appearance = Appearance()
	
	var body: some View {
		VStack {
			Spacer()
			GithubLogoImage()
			Text(appearance.loadingText)
			Spacer().frame(height: appearance.spacerHeight)
			ProgressView().progressViewStyle(CircularProgressViewStyle())
			Spacer()
		}
		.frame(maxWidth: .infinity, maxHeight: .infinity)
		.edgesIgnoringSafeArea(.all)
	}
}
